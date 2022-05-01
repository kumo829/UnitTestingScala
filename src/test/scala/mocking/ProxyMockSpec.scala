package mocking

import com.h2.entities.Dollars
import com.h2.services.AccountService
import matchers.UnitSpec
import org.scalamock.scalatest.MockFactory

import java.util.UUID

class ProxyMockSpec extends UnitSpec with MockFactory{
  behavior of "Account Service with Mocks"

  it should "mock a Trait" in {
    val mocked = mock[AccountService]

    val customerId = UUID.randomUUID()
    val productId = UUID.randomUUID()
    val tenDollars = Dollars(10)

    mocked.openDepositAccount _ expects(customerId, productId, tenDollars)
    mocked.openDepositAccount(customerId, productId, tenDollars)
  }

  it should "return mocked value" in {
    val mocked = mock[AccountService]

    val customerId = UUID.randomUUID()
    val productId = UUID.randomUUID()
    val tenDollars = Dollars(10)
    val accountId = UUID.randomUUID()

    mocked.openDepositAccount _ expects(customerId, productId, tenDollars) returning accountId

    mocked.openDepositAccount(customerId, productId, tenDollars) should be (accountId)
  }

  it should "throw an exception" in {
    val mocked = mock[AccountService]

    val customerId = UUID.randomUUID()
    val productId = UUID.randomUUID()
    val tenDollars = Dollars(10)

    mocked.openDepositAccount _ expects(customerId, productId, tenDollars) throwing new IllegalArgumentException

    an[IllegalArgumentException] should be thrownBy mocked.openDepositAccount(customerId, productId, tenDollars)
  }

  it should "match wildcard pattern" in {
    val mocked = mock[AccountService]

    val customerId = UUID.randomUUID()

    mocked.openDepositAccount _ expects(customerId, *, *)
    mocked.openDepositAccount(customerId, UUID.randomUUID(), Dollars(100))
  }


  it should "count number of times" in {
    val mocked = mock[AccountService]

    val customerId = UUID.randomUUID()

    (mocked.openDepositAccount _ expects(customerId, *, *)).atLeastTwice()

    (1 to 10).foreach{i =>
      mocked.openDepositAccount(customerId, UUID.randomUUID(), Dollars(100))
      mocked.openDepositAccount(customerId, UUID.randomUUID(), Dollars(100))
    }
  }
}

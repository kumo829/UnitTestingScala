package mocking

import com.h2.services.Currency
import matchers.UnitSpec
import org.scalamock.scalatest.MockFactory

class FunctionMockSpec extends UnitSpec with MockFactory {
  behavior of "Currency's Mocking"

  it should "be able to mock a higher-order function for any input argument and anyNumberOfTimes" taggedAs (Fast) in {
    val currencies: List[Currency] = List("100 USD", "20 EUR", "1000 CAD", "1 USD")

    def getCurrency(criteria: Currency => Boolean): List[Currency] = currencies.filter(criteria)

//    def criteria: Currency => Boolean = (c: Currency) => c.code === "CAD"

    val mocked = mockFunction[Currency, Boolean]
    mocked.expects(*).anyNumberOfTimes()

    getCurrency(mocked)
//    getCurrency(criteria) should have size 1
  }

}

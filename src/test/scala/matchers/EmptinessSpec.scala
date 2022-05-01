package matchers

import com.h2.services.{Currency, CustomerService}

class EmptinessSpec extends UnitSpec {
  val customerService: CustomerService = new CustomerService {}

  behavior of "Customer for emptiness"

  it should "return empty for customer's last name" in {
    val (first, last, email, dateOfBirth) = ("John", "", "john@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.last should be (empty)
    customer.last shouldBe empty
  }


  behavior of "Currencies inside wallet"

  it should "be empty when no currencies are added to the wallet" in {
    val wallet: List[Currency] = List.empty

    wallet should be (empty)

  }
}

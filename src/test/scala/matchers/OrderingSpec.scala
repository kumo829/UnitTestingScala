package matchers

import com.h2.services.Currency

class OrderingSpec extends UnitSpec {
  behavior of "Currency conversion cost in comparison"

  it should "report equal cost for 10 USD, 10USD" in {
    val tenUsd: Currency = "10 USD"
    val anotherTenUsd: Currency = "10 USD"

    tenUsd.costInDollars.amount should be >= anotherTenUsd.costInDollars.amount
  }


  it should "report high cost for 100 USD, 10USD" in {
    val tenUsd: Currency = "10 USD"
    val hundredUsd: Currency = "100 USD"

    hundredUsd.costInDollars.amount should be > tenUsd.costInDollars.amount
  }


  it should "report less cost for 1 USD, 10USD" in {
    val tenUsd: Currency = "10 USD"
    val oneUsd: Currency = "1 USD"

    oneUsd.costInDollars.amount should be < tenUsd.costInDollars.amount
  }

  it should "report CAD < USD" in {
    "CAD" should be < "USD"
  }
}

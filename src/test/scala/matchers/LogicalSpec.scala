package matchers

import com.h2.services.Currency

class LogicalSpec extends UnitSpec {
  behavior of "Currencies as logical and|or"

  it should "successfully match logical expression with 'and' condition for currency" in {
    val tenCad: Currency = "10 CAD"

    tenCad.costInDollars.amount should(be > 0 and be <= 12)
  }

  it should "successfully match logical expression with 'or' condition for currency" in {
    val tenCad: Currency = "10 CAD"

    tenCad.code should (have length 0 or equal("CAD"))
  }
}

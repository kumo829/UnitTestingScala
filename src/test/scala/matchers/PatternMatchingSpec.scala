package matchers

import com.h2.entities.Dollars
import com.h2.services.Currency
import org.scalatest.Inside

class PatternMatchingSpec extends UnitSpec with Inside {
  behavior of "Currency when pattern matching"

  it should "be able to assert on the values of a currency" in {
    val tenCad: Currency = "10 CAD"

    inside(tenCad) { case Currency(code, amount, costInDollars) =>
      code should equal ("CAD")
      amount should equal (10.0 +- 5.0)
      costInDollars should be > Dollars(10)
    }
  }

  it should "be able to 'matchPattern' on the currency code" in {
    val tenCad: Currency = "10 CAD"
    tenCad should matchPattern { case Currency("CAD", _, _) =>
    }
  }
}

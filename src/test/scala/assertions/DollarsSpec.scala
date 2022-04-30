package assertions

import com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarsSpec extends AnyFlatSpec{
  behavior of "A Dollar"

  it should "create a correct Dollar object for number 10 as input" in {
    val tenDollars = Dollars(10)

    assert("$10" === tenDollars.toString)
  }

  it should "correctly identify that $10 > $5" in {
    val tenDollars = Dollars(10)
    val fiveDollars = Dollars(5)

    assert(tenDollars > fiveDollars)
  }


  it should "correctly identify that $2 < $5" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assert(twoDollars < fiveDollars)
  }

  it should "correctly add two Dollars amount" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assertResult("$7"){
      (fiveDollars + twoDollars).toString
    }
  }

  it should "correctly subtract two Dollars amount" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assertResult("$3"){
      (fiveDollars - twoDollars).toString
    }
  }

  it should "throw an exception when an invalid integer is provided to create Dollars" in {
    assertThrows[ArithmeticException]{
      Dollars(10 / 0)
    }
  }
}

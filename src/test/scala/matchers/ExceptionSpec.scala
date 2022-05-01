package matchers

import com.h2.services.Currency

class ExceptionSpec extends UnitSpec {
  behavior of "Currency during exception"

  it should "throw and exception when invalid number is provided in the currency string" in {
    a [NumberFormatException] should be thrownBy Currency.stringToCurrency("One CAD")
    an [NumberFormatException] should be thrownBy Currency.stringToCurrency("One CAD")
  }

  it should "provide a detailed description of the exception" in {
    val exception = the[NumberFormatException] thrownBy Currency.stringToCurrency("One CAD")

    exception.getMessage should include ("One")
  }
}

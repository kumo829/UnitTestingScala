package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec {
  behavior of "An Email"

  it should "return an Email object for a valid String" in {
    val email = Email("me@google.com")

    assert(email.localPart === "me")
    assert(email.domain === "google.com")
  }

  it should "return another Email objet for another valid String" in {
    assertResult("not-me") {
      Email("not-me@google.com").localPart
    }
  }

  it should "throw an exception when an email does not contain '@' symbol" in {
    withClue("expected exception since email does not have '@' symbol") {
      assertThrows[IllegalArgumentException] {
        Email("me.com")
      }
    }
  }

  it should "throw an exception when an email contains more than one '@' symbol" in {
    assertThrows[IllegalArgumentException] {
      Email("me@google@com")
    }
  }


  it should "intercept the correct error message when no '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException] {
      Email("me.com")
    }

    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("does not contain '@'"))
  }
}

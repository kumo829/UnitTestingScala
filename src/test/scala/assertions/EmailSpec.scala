package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec{
  behavior of "An Email"

  it should "return an Email object for a valid String" in {
    val email = Email("me@google.com")

    assert(email.localPart === "me")
    assert(email.domain === "google.com")
  }
}

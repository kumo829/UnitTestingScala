package matchers

import com.h2.services.Currency

class ContainerSpec extends UnitSpec {
  behavior of "Currencies in a wallet"

  it should "contain a currency that is added to a List wallet" in {
    val oneUsd: Currency = "1 USD"
    val oneEur: Currency = "1 EUR"
    val oneCad: Currency = "1 CAD"

    val wallet = List(oneUsd, oneEur, oneCad)

    wallet should contain(oneUsd)
  }

  it should "not contain a currency that is added to a List wallet" in {
    val oneUsd: Currency = "1 USD"
    val oneEur: Currency = "1 EUR"
    val oneCad: Currency = "1 CAD"
    val oneNzd: Currency = "1 NZD"

    val wallet = List(oneUsd, oneEur, oneCad)

    wallet should not contain oneNzd
  }

  it should "contain a currency that is added to a Set wallet" in {
    val oneUsd: Currency = "1 USD"
    val oneEur: Currency = "1 EUR"
    val oneCad: Currency = "1 CAD"

    val wallet = Set(oneUsd, oneEur, oneCad)

    wallet should contain(oneUsd)
  }

  it should "contain a currency that is added to a Map wallet" in {
    val oneUsd: Currency = "1 USD"
    val oneEur: Currency = "1 EUR"
    val oneCad: Currency = "1 CAD"

    val wallet: Map[String, Currency] = Map(
      "USD" -> oneUsd,
      "EUR" -> oneEur,
      "CAD" -> oneCad
    )

    wallet should contain("CAD" -> oneCad)
  }


  it should "contain a oneOf 1 CAD that is added to a Set wallet" in {
    val oneUsd: Currency = "1 USD"
    val oneEur: Currency = "1 EUR"
    val oneCad: Currency = "1 CAD"
    val oneMxn: Currency = "1 MXN"

    val wallet:Set[Currency] = Set(oneUsd, oneUsd, oneEur, oneEur)

    wallet should contain oneOf (oneUsd, oneCad)
    wallet should contain oneElementOf List(oneEur, oneCad)
    wallet should contain noneOf (oneCad, oneMxn)
    wallet should contain noElementsOf List(oneCad, oneMxn)
  }
}

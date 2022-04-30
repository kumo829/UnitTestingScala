# Unit Testing in Scala
This project uses `ScalaTest` to write all the unit tests in the course.


## Test styles in ScalaTest

There are 8 testing styles offered by ScalaTest

1. `FlatSpec`. Teams wishing to move from xUnit to BDD style test. It is the recommended style when starting with ScalaTest for the first time. It is called **Flat** because the Specification Text and the Test are in a flat way (which makes it clean and easy to work with):

```scala
class HelloWorldSpec extends AnyFlatSpec{

  behavior of "Hello World"

  it should "start with Hello" in {
    assert("Hello World".startsWith("Hello"))
  }
}
```

2. `FunSuite`. For teams coming from xUnit frameworks.
```scala
class HelloWorldFunSuiteSpec extends AnyFunSuite{

  test("A string 'Hello World' should start with 'Hello'") {
    assert("Hello World".startsWith("Hello"))
  }
}
```

3. `FunSpec`. Teams coming from Ruby's RSpec.
```scala
class HelloWorldFunSpec extends AnyFunSpec{

  describe("A 'Hello World' String"){
    it ("should start with 'Hello'") {
     assert("Hello World".startsWith("Hello"))
    }
  }
}
```

4. `FeatureSpec`. Intended for acceptance testing.
```scala
class HelloWorldFeatureSpec extends AnyFeatureSpec with GivenWhenThen{

  info("As a developer")
  info("I want to test Strings")
  
  feature("A String") {
      scenario("When a user provides 'Hello World' as input") {
        Then("The input must start with 'Hello'")
        assert("Hello World".startsWith("Hello"))
      }
  }
}
```

5. `WordSpec`. Teams coming from spec or spec2 library. 
6. `FreeSpec`. Teams experienced in BDD style.
7. `PropSpec`. Teams wanting to perform Property-Based testing.


## Verify if the project is setup for the course
```shell script
sbt "runMain BankOfScala"
```

## Module 03 - Writing the First Test
### Add the scalatest dependency in `build.sbt`
```text
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"
```

### Compiling & Running test using Scala
- Download the [ScalaTest](https://oss.sonatype.org/content/groups/public/org/scalatest/scalatest-app_2.13/3.1.0/scalatest-app_2.13-3.1.0.jar) jar file. This is available on [Quickstart](http://www.scalatest.org/quick_start) page  
- Download the [scala-xml](https://repo1.maven.org/maven2/org/scala-lang/modules/scala-xml_2.13/1.2.0/scala-xml_2.13-1.2.0.jar) jar file
- Compile the Test class
```shell script
scalac -classpath "*.jar" HelloWorldSpec.scala
```
- Run the Test
```shell script
scala -classpath "*.jar" org.scalatest.run HelloWorldSpec
```

- Run Using sbt
```shell script
sbt test 
```

- Run a single test using sbt
```shell script
sbt "testOnly HelloWorldSpec"
```

- Listen for changes in the test file (my personal favorite 😊)
```shell script
sbt "~testOnly *Hello*"
```

## Module 07 - Mocking and Tagging Your Tests
The latest ScalaMock release `4.4.0` has not been updated with the latest ScalaTest release `3.1.0`.
There is an open [pull request](https://github.com/paulbutcher/ScalaMock/pull/274) to merge the changes.

However, there are no breaking or conflicting changes between ScalaTest and ScalaMock.
So, in order to learn ScalaMock, you can learn it with the ScalaTest release `3.0.8` which is 1 release behind the latest ScalaTest `3.1.0`.

Clone the repository
```shell script
https://github.com/hhimanshu/Unit-Testing-In-Scala-Mocking
```

The test source is available under `src/test/scala`.

To run all the tests, run
```shell script
test
```

To run the test including a specific tag, run
```shell script
testOnly -- -n com.h2.tags.Fast
testOnly -- -n com.h2.tags.Slow
```

To run the test excluding a specific tag, run
```shell script
testOnly -- -l com.h2.tags.Fast
testOnly -- -l com.h2.tags.Slow
```


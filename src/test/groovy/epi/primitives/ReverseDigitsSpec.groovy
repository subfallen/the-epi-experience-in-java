package epi.primitives

import spock.lang.*

import static epi.primitives.ReverseDigits.given

class ReverseDigitsSpec extends Specification {
  @Unroll
  def 'reverse #instance'() {
    given:
    def expected = epiAnswer(instance)
    and:
    def actual = given(instance)

    expect:     
    expected == actual

    where:
    instance << (1..10).collect { randomInstance() }
  }

  private def epiAnswer(long x) {
    def asString = (x as String)
    def toBeReversed = (asString[0] == '-') ? asString[1..<asString.length()] : asString
    def reversed = ((asString[0] == '-' ? '-' : '') + toBeReversed.reverse())
    reversed as long
  }

  private def randomInstance() {
    (long)(new Random().nextLong() / 10)
  }
}

package epi.primitives

import spock.lang.*

import static epi.primitives.HasPalindromeDigits.given

class HasPalindromeDigitsSpec extends Specification {
  @Unroll
  def 'tests #instance'() {
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
    return asString == asString.reverse()
  }

  private def randomInstance() {
    def r = new Random()
    if (r.nextBoolean()) {
      def x = Math.abs(r.nextInt(1_000_000_00))
      def asString = (x as String)
      return (asString.reverse() + asString) as long
    } else {
      return new Random().nextLong()
    }
  }
}

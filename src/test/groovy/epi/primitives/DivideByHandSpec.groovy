package epi.primitives

import spock.lang.*

import static epi.primitives.DivideByHand.given

class DivideByHandSpec extends Specification {
  @Unroll
  def 'divides #instance.dividend by #instance.divisor'() {
    given:
    def expected = epiAnswer(instance.dividend, instance.divisor)
    and:
    def actual = given(instance.dividend, instance.divisor)

    expect:
    expected == actual

    where:
    instance << (1..10).collect { randomInstance() }
  }

  private def epiAnswer(long x, long y) {
    (long)(x / y)
  }

  private def randomInstance() {
    // divides 2522890769743799115 by 61603658860987500
    def r = new Random()
    [ dividend: Math.abs(r.nextLong()), divisor: Math.abs(r.nextLong()) ]
  }
}

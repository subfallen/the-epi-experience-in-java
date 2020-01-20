package epi.primitives

import spock.lang.*

import static epi.primitives.ExpByHand.given

class ExpByHandSpec extends Specification {
  @Unroll
  def 'exponentiates #instance.base by #instance.pow'() {
    given:
    def expected = epiAnswer(instance.base, instance.pow)
    and:
    def actual = given(instance.base, instance.pow)

    expect:
    Math.abs(expected - actual) < 0.001

    where:
    instance << (1..10).collect { randomInstance() }
  }

  private def epiAnswer(double x, int y) {
    Math.pow(x, y)
  }

  private def randomInstance() {
    def r = new Random()
    [ base: r.nextDouble() * (1 + r.nextInt(10)), pow: Math.abs(r.nextInt(10)) ]
  }
}

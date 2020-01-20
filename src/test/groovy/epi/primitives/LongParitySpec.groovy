package epi.primitives

import spock.lang.*

class LongParitySpec extends Specification {
  @Shared
  def NUM_PARAMETERIZATIONS = 10

  @Unroll
  def 'parity (via cache) of #vWithParity.v is #vWithParity.parity'() {
    expect:
    LongParity.compute(vWithParity.v) == vWithParity.parity

    where:
    vWithParity << (1..NUM_PARAMETERIZATIONS).collect { randomParameterization() }
  }

  @Unroll
  def 'parity (via associativity) of #vWithParity.v is #vWithParity.parity'() {
    expect:
    LongParity.computeViaAssociation(vWithParity.v) == vWithParity.parity

    where:
    vWithParity << (1..NUM_PARAMETERIZATIONS).collect { randomParameterization() }
  }

  private def randomParameterization() {
    def v = 0L
    def r = new Random()
    def parity = 0
    (0..<64).each {
      if (r.nextInt() % 2) {
        v |= 1L << it
        parity ^= 1
      }
    }
    [v: v, parity: parity]
  }
}

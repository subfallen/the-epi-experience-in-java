package epi.primitives

import spock.lang.*

import static epi.primitives.BitReverse.reverseBits

class BitReverseSpec extends Specification {
  @Unroll
  def 'reverses #instance'() {
    given:
    def expected = epiAnswer(instance)
    and:
    def actual = BitReverse.reverseBits instance
    and:
    println "Reversing ${asBitString instance} :: EXPECTED=${asBitString expected} & ACTUAL=${asBitString actual}"

    expect:
    expected == actual

    where:
    instance << (1..10).collect { randomInstance() }
  }

  private def epiAnswer(long n) {
    long revN = 0
    (0..<64).each {
      revN = (revN << 1) + (n & 1)
      n >>>= 1
    }
    revN
  }

  private def asBitString(long n) {
    def sb = new StringBuilder()
    (0..<64).each {
      sb.append(n & 1)
      n >>>= 1
    }
    sb.toString().reverse()
  }

  private def randomInstance() {
    new Random().nextLong()
  }
}

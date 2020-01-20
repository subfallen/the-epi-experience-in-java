package epi.primitives

import spock.lang.*

import static epi.primitives.BitSwap.swapBits

class BitSwapSpec extends Specification {
  @Unroll
  def 'swaps #instance.i and #instance.j in #instance.n'() {
    given:
    def expected = epiAnswer(instance.i, instance.j, instance.n)
    and:
    def actual = swapBits(instance.i, instance.j, instance.n)

    expect:
    expected == actual

    where:
    instance << (1..10).collect { randomInstance() }
  }

  private def epiAnswer(int i, int j, long n) {
    if (((n >> i) & 1) != ((n >>> j) & 1)) {
      long mask = (1L << j) | (1L << i)
      n ^= mask
    }
    n
  }

  private def randomInstance() {
    def r = new Random()
    return [ i: r.nextInt(64), j: r.nextInt(64), n: r.nextLong() ]
  }
}

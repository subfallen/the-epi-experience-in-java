package epi.primitives

import spock.lang.*

import static epi.primitives.NearestOfEqualWeight.given

class NearestOfEqualWeightSpec extends Specification {
  @Unroll
  def 'finds nearest of equal weight for #instance'() {
    given:
    def expected = epiAnswer(instance)
    and:
    def actual = NearestOfEqualWeight.given instance
    and:
    println "Nearest for $instance :: EXPECTED=$expected & ACTUAL=$actual"

    expect:
    expected == actual

    where:
    instance << (1..10).collect { randomInstance() }
  }

  static final int NUM_UNSIGNED_BITS = 63
  private def epiAnswer(long x) {
    for (int i = 0; i < NUM_UNSIGNED_BITS - 1; i++) {
      if ((((x >>> i) & 1) != ((x >>> (i + 1)) & 1))) {
        x ^= (1L << i) | (1L << (i + 1));
        return x;
      }
    }
    throw new IllegalArgumentException("Nope!");
  }

  private def randomInstance() {
    Math.abs(new Random().nextLong())
  }
}

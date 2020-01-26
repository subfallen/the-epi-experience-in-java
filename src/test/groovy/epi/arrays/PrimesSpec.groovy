package epi.arrays

import spock.lang.*
import java.util.stream.Stream
import java.util.function.Function
import static java.util.stream.Collectors.toList
import static java.util.stream.Collectors.toMap

import static epi.arrays.Primes.upTo

class PrimesSpec extends Specification {
  @Unroll
  def 'lists primes up to #n'() {
    given:
    def actual = upTo(n)
    println "Primes <= $n :: $actual"
    and:
    def expected = epiAnswer(n)

    expect:     
    expected == actual

    where:
    n << (1..10).collect { randomInstance(100) }
  }

  private List<Integer> epiAnswer(int n) {
    Stream.iterate(BigInteger.TWO, {bi -> bi.nextProbablePrime()})
        .limit(100L)
        .map({ bi -> bi.intValue() })
        .filter({ i -> i <= n })
        .collect(toList())
  }

  private def randomInstance(int n) {
    new Random().nextInt(n)
  }
}

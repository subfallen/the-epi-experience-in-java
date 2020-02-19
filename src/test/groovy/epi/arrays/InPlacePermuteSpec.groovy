package epi.arrays

import spock.lang.*
import java.util.stream.Stream
import java.util.function.Function
import static java.util.stream.Collectors.toList
import static java.util.stream.Collectors.toMap

import static epi.arrays.InPlacePermute.permute

class InPlacePermuteSpec extends Specification {
  @Unroll
  def 'applies #p'() {
    given:
    def actual = (0..<12).collect { it }
    and:
    def origP = new ArrayList<Integer>(p)
    permute(actual, p)
    println "[0, ..., 12] under $p :: $actual"
    and:
    def expected = bruteForce(p)

    expect:     
    expected == actual
    origP == p

    where:
    p << (1..10).collect { randomInstance(12) }
  }

  private List<Integer> bruteForce(List<Integer> p) {
    def aPrime = new ArrayList<Integer>(Collections.nCopies(12, 0))
    (0..<12).each {
        aPrime[p[it]] = it
    }
    aPrime
  }

  private def randomInstance(int n) {
    def r = new Random()
    def weights = (0..<n).collect { r.nextDouble() } 
    def p = (0..<n).collect { it }
    p.stream().sorted({ i, j -> weights.get(i) <=> weights.get(j) }).collect(toList())
  }
}

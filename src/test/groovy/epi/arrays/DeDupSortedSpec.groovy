package epi.arrays

import spock.lang.*
import java.util.stream.Stream
import java.util.function.Function
import static java.util.stream.Collectors.toList
import static java.util.stream.Collectors.toMap

import static epi.arrays.DeDupSorted.dedup

class DeDupSortedSpec extends Specification {
  @Unroll
  def 'dedups #l'() {
    given:
    def prefix = bruteForce(l)
    println "Sorted with dups :: $l"
    and:
    def numRetained = dedup(l, false)
    println "Deduped ($numRetained uniques) :: $l"

    expect:     
    prefix == l[0..<prefix.size()]

    where:
    l << (1..10).collect { randomInstance(20, 5) }
  }

  @Unroll
  def 'dedups #l with echoes of repeated elements'() {
    given:
    def echoedPrefix = bruteForceWithEcho(l)
    println "Sorted with dups :: $l"
    and:
    def numRetained = dedup(l, true)
    println "Deduped ($numRetained uniques + echoes) :: $l"

    expect:     
    echoedPrefix == l[0..<echoedPrefix.size()]

    where:
    l << (1..10).collect { randomInstance(20, 15) }
  }

  private def bruteForceWithEcho(List<Integer> l) {
    Map<Integer, Integer> counts = l.stream().collect(toMap(
      Function.identity(),
      { ignore -> 1 },
      { a, b -> a + b }
    ))
    counts.keySet().stream()
      .flatMap({ i -> (counts[i] > 1) ? Stream.of(i, i) : Stream.of(i) })
      .sorted()
      .collect(toList())
  }

  private def bruteForce(List<Integer> l) {
    l.stream().distinct().collect(toList())
  }

  private def randomInstance(int n, int m) {
    def r = new Random()
    def l = (0..<n).collect { r.nextInt(m) }
    Collections.sort(l)
    l
  }
}

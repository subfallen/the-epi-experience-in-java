package epi.arrays

import spock.lang.*
import java.util.stream.Stream
import java.util.function.Function
import static java.util.stream.Collectors.toList
import static java.util.stream.Collectors.toMap

import static epi.arrays.BuySellTwice.maxValue

class BuySellTwiceSpec extends Specification {
  @Unroll
  def 'optimizes #prices'() {
    given:
    def actual = maxValue(l)
    println "Max derived as $actual for :: $l"
    and:
    def expected = epiAnswer(l)

    expect:     
    expected == actual

    where:
    l << (1..10).collect { randomInstance(20, 500) }
  }

  private int epiAnswer(List<Integer> prices) {
    int n = prices.size()
    int maxTotal = 0
    List<Integer> prefixProfits = new ArrayList<Integer>()
    int minPrice = Integer.MAX_VALUE

    for (int i = 0; i < n; i++) {
        minPrice = Math.min(minPrice, prices.get(i))
        maxTotal = Math.max(maxTotal, prices.get(i) - minPrice)
        prefixProfits.add(maxTotal)
    }

    int maxSoFar = Integer.MIN_VALUE
    for (int i = n - 1; i > 0; i--) {
        maxSoFar = Math.max(maxSoFar, prices.get(i))
        maxTotal = Math.max(maxTotal, maxSoFar - prices.get(i) + prefixProfits.get(i - 1))
    }
    maxTotal
  }

  private def randomInstance(int n, int m) {
    def r = new Random()
    (0..<n).collect { r.nextInt(m) }
  }
}

package epi.arrays

import spock.lang.*
import java.util.stream.Stream
import java.util.function.Function
import static java.util.stream.Collectors.toList
import static java.util.stream.Collectors.toMap

import static epi.arrays.BuySellOnce.maxValue

class BuySellOnceSpec extends Specification {
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
    int minPrice = Integer.MAX_VALUE, maxProfit = 0
    prices.each {
        maxProfit = Math.max(maxProfit, it - minPrice)
        minPrice = Math.min(minPrice, it)
    }
    maxProfit
  }

  private def randomInstance(int n, int m) {
    def r = new Random()
    (0..<n).collect { r.nextInt(m) }
  }
}

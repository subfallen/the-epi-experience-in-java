package epi.primitives

import spock.lang.*
import static java.util.function.Function.identity
import static java.util.stream.Collectors.*

class UniformRandomSpec extends Specification {
  @Shared
  def r = new Random()

  @Subject
  def unifRand = new UniformRandom({ r.nextBoolean() })

  def 'is reasonably random'() {
    given:
    def n = 5
    def (a, b) = [0, n - 1] 
    def p = 1.0 / n
    def sigmaSquared = p * (1 - p)

    def N = 10_000
    def sampleMu = p
    def sampleSigma = Math.sqrt(sigmaSquared / N)

    when:
    def results = (0..<N).collect {
      unifRand.nextBetween(a, b)
    }.inject(new HashMap()) {
      counts, v -> 
        counts.merge(v, 1, { m, ignore -> m + 1 })
        counts
    }
    println results

    then:
    println "Expected proportion: ${sampleMu} +/- ${3 * sampleSigma}"
    results.every {
      v, vN -> 
        println "Proportion of $v is ${vN / N}"
        Math.abs(vN / N - sampleMu) < 3 * sampleSigma
    }
  }
}

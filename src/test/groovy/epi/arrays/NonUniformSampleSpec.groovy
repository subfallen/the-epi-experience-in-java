package epi.arrays

import java.util.stream.*
import spock.lang.*
import epi.arrays.NonUniformSample
import java.math.MathContext
import epi.test.ProbUtils

class NonUniformSampleSpec extends Specification {
    def 'has expected proportions'() {
        given:
        def n = 100_000
        def counts = [:]

        when:
        def dist = [0: 0.1, 1: 0.3, 2: 0.6]
        and:
        def sampler = NonUniformSample.from(dist)
        (0..<n).each {
            counts.merge(sampler.get(), 1, { a, b -> a + b })
        }

        then:
        counts.every {
            entry -> 
                def test = ProbUtils.newBernoulliToleranceTest(n, dist[entry.key], 3)
                test(entry.value)
        }
    }
}

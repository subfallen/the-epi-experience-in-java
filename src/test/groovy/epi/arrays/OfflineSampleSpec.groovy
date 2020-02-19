package epi.arrays

import java.util.stream.*
import spock.lang.*
import static epi.arrays.OfflineSample.*
import java.math.MathContext

class OfflineSampleSpec extends Specification {
    def 'has expected proportions'() {
        given:
        def n = 100_000
        def counts = [:]
        for (int i = 0; i <= 2; i++) {
            for (int j = i + 1; j <= 3; j++) {
                for (int k = j + 1; k <= 4; k++) {
                    def key = "$i,$j,$k".toString()
                    println "Adding $key"
                    counts[key] = 0
                }
            }
        }
        and:
        def a = (0..<5).collect { it }

        when:
        true
        (0..<n).each {
            sample(a, 3)
            def key = a[0..2].stream()
                .sorted()
                .map({ i -> i.toString() })
                .collect(Collectors.joining(','))
            counts.merge(key, 1, { i, j -> i + j })
        }
        and:
        def distinct = counts.size()
        def mathCtx = new MathContext(10)
        def sigma = ((1 / distinct) * (1 - (1 / distinct)) * n).sqrt(mathCtx).intValue()
        def mu = (n / distinct).intValue()
        println "Each of the $distinct keys should have about $mu +/- ${3 * sigma} appearances"
        def low = mu - (3 * sigma)
        def high = mu + (3 * sigma)

        then:
        counts.every {
            low <= it.value && it.value <= high 
        }
    }
}

package epi.arrays

import java.util.stream.*
import spock.lang.*
import static epi.arrays.RandomPerm.*
import static epi.arrays.NextPerm.*
import java.math.MathContext

class RandomPermSpec extends Specification {
    def 'has expected proportions'() {
        given:
        def n = 100_000
        def counts = [:]
        def perm = (0..<5).collect { it } as int[]
        def getKey = {
            a -> Arrays.stream(a).boxed().map({ i -> i.toString() }).collect(Collectors.joining(','))
        }
        while (true) {
            def key = getKey(perm)
            println "Adding $key"
            counts[key] = 0
            def nextP = from(perm)
            if (nextP.length == 0) {
                break
            }
        }

        when:
        (0..<n).each {
            def randPerm = upTo(5)    
            def key = randPerm.stream().map({ i -> i.toString() }).collect(Collectors.joining(','))
            counts.merge(key, 1, { a, b -> a + b })
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

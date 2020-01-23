package epi.arrays

import spock.lang.*
import static epi.arrays.CanAdvance.can

class CanAdvanceSpec extends Specification {
    @Unroll
    def 'identifies #l correctly'() {
        given:
        def expected = epiAnswer(l)

        when:
        def actual = can(l)
        and:
        println "$l :: actual = $actual, expected = $expected"

        then:
        expected == actual

        where:
        l << (0..<10).collect { instance(20, 5) }
    }

    private boolean epiAnswer(List<Integer> l) {
        int furthest = 0, lastI = l.size() - 1
        for (int i = 0; i <= furthest && furthest < lastI; i++) {
            furthest = Math.max(furthest, i + l.get(i))
        }
        furthest >= lastI
    }

    private List<Integer> instance(int m, int n) {
        def r = new Random()

        (0..<m).collect {
            r.nextInt(n)
        }
    }
}

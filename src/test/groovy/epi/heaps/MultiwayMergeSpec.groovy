package epi.heaps

import spock.lang.*
import epi.heaps.MultiwayMerge

class MultiwayMergeSpec extends Specification {
    def 'from the book'() {
        given:
        def a = [3, 5, 7]
        def b = [0, 6]
        def c = [0, 6, 28]
        and:
        def expected = [0, 0, 3, 5, 6, 6, 7, 28]

        when:
        def actual = MultiwayMerge.merge(a, b, c)
        
        then:
        actual == expected
    }
}

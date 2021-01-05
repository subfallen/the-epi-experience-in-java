package epi.heaps

import spock.lang.*
import epi.heaps.FinishAlmostSorted

class FinishAlmostSortedSpec extends Specification {
    def 'from the book'() {
        given:
        def start = [3, -1, 2, 6, 4, 5, 8]

        when:
        def actual = FinishAlmostSorted.finish(start, 2)
        
        then:
        actual == start.sort()
    }
}

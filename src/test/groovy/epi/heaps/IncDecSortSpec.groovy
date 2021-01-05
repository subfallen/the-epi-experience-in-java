package epi.heaps

import spock.lang.*
import epi.heaps.IncDecSort

class IncDecSortSpec extends Specification {
    def 'from the book'() {
        given:
        def start = [57, 131, 493, 294, 221, 339, 418, 452, 442, 190]

        when:
        def actual = IncDecSort.sortIncDec(start, 4)
        
        then:
        actual == start.sort()
    }
}

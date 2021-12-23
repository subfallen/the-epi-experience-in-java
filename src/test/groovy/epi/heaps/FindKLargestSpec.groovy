package epi.heaps

import spock.lang.*
import epi.heaps.FindKLargest

class FindKLargestSpec extends Specification {
    def 'works for book example'() {
        given:
        int[] heap = [561, 314, 401, 28, 156, 359, 271, 11, 3]

        when:
        def kLargest = FindKLargest.kLargest(heap, 4)

        then:
        kLargest == [561, 401, 359, 314]
    }
}

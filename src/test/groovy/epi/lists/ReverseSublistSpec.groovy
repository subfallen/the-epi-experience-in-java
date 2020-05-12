package epi.lists

import spock.lang.*
import epi.lists.Node
import static epi.lists.ReverseSublist.*

class ReverseSublistSpec extends Specification {
    def 'worksWithProperSublist'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i')

        when:
        def q = reverse(p, 2, 4)

        then:
        '[a, g, e, c, i]' == Node.toString(q)
    }

    def 'worksWithPrefixSublist'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i')

        when:
        def q = reverse(p, 1, 2)

        then:
        '[c, a, e, g, i]' == Node.toString(q)
    }

    def 'worksWithSuffixSublist'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i')

        when:
        def q = reverse(p, 3, 5)

        then:
        '[a, c, i, g, e]' == Node.toString(q)
    }

    def 'worksWithDegenerateSublist'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i')

        when:
        def q = reverse(p, 3, 3)

        then:
        '[a, c, e, g, i]' == Node.toString(q)
    }

    def 'iaeOnOutOfBoundsSublist'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i')

        when:
        def q = reverse(p, 3, 30)

        then:
        def iae = thrown IllegalArgumentException
        and:
        iae.message == 'List rooted @ (a, ->) has no sublist [3, 30]!'
    }
}

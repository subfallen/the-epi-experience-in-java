package epi.lists

import spock.lang.*
import epi.lists.Node
import epi.lists.EvenOddMerge

class EvenOddMergeSpec extends Specification {
    def 'works as expected'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i', 'j')

        when:
        def q = EvenOddMerge.of(p)

        then:
        Node.toString(q) == '[a, e, i, c, g, j]'
    }

    def 'works as expected for odd length'() {
        given:
        def p = Node.listOf('c', 'e', 'g', 'i', 'j')

        when:
        def q = EvenOddMerge.of(p)

        then:
        Node.toString(q) == '[c, g, j, e, i]'
    }
}

package epi.lists

import spock.lang.*
import epi.lists.Node
import epi.lists.LlSum

class LlSumSpec extends Specification {
    def 'carries as expected'() {
        given:
        def p = Node.listOf(1, 2, 7)
        and:
        def q = Node.listOf(9, 8, 2)

        when:
        def u = LlSum.sum(p, q)

        then:
        Node.toString(u) == '[0, 1, 0, 1]'
    }

    def 'handles unequal lens'() {
        given:
        def p = Node.listOf(1, 2, 7, 9, 9)
        and:
        def q = Node.listOf(9, 8, 2)

        when:
        def u = LlSum.sum(p, q)

        then:
        Node.toString(u) == '[0, 1, 0, 0, 0, 1]'
    }
}

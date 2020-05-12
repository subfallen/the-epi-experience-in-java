package epi.lists

import spock.lang.*
import epi.lists.Node
import static epi.lists.FirstShared.*

class FirstSharedSpec extends Specification {
    def 'findsOverlap'() {
        given:
        def p = Node.listOf('a', 'b', 'c', 'd')
        def q = Node.listOf('e')
        and:
        q.setNext(p.next().next())

        when:
        def o = intersection(p, q)

        then:
        o.value() == 'c'
    }

    def 'findsImmediateOverlap'() {
        given:
        def p = Node.listOf('a', 'b', 'c', 'd')

        when:
        def o = intersection(p, p)

        then:
        o.value() == 'a'
    }
}

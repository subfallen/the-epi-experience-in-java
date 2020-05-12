package epi.lists

import spock.lang.*
import epi.lists.Node
import static epi.lists.CycleStart.*
import static epi.lists.FirstSharedWithCycles.*

class FirstSharedWithCyclesSpec extends Specification {
    def 'findsOverlap'() {
        given:
        def p = Node.cycleTerminatedListOf(List.of('a', 'c', 'e', 'g', 'i'), 'e')
        def q = Node.listOf('k')
        and:
        q.setNext(p.next().next().next())

        when:
        def o = intersection(p, q)

        then:
        o.value() == 'g'
    }

    def 'findsAnotherOverlap'() {
        given:
        def p = Node.cycleTerminatedListOf(List.of('a', 'c', 'e', 'g', 'i'), 'e')
        def q = Node.listOf('k')
        and:
        q.setNext(p)

        when:
        def o = intersection(p, q)

        then:
        o.value() == 'a'
    }
}

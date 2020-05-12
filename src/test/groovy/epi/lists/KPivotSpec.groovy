package epi.lists

import spock.lang.*
import epi.lists.Node
import epi.lists.KPivot

class KPivotSpec extends Specification {
    def 'works as expected for one equal'() {
        given:
        def p = Node.listOf(1, 11, 2, 12, 10, 3, 13, 4, 14)

        when:
        def q = KPivot.of(p, 10)

        then:
        Node.toString(q) == '[1, 2, 3, 4, 10, 11, 12, 13, 14]'
    }

    def 'works as expected for no small one equal'() {
        given:
        def p = Node.listOf(11, 12, 10, 13, 14)

        when:
        def q = KPivot.of(p, 10)

        then:
        Node.toString(q) == '[10, 11, 12, 13, 14]'
    }

    def 'works as expected for no large two equal'() {
        given:
        def p = Node.listOf(1, 2, 10, 3, 4, 10)

        when:
        def q = KPivot.of(p, 10)

        then:
        Node.toString(q) == '[1, 2, 3, 4, 10, 10]'
    }
}

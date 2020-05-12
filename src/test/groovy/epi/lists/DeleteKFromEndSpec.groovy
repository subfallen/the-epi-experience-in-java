package epi.lists

import spock.lang.*
import epi.lists.Node
import epi.lists.DeleteKFromEnd

class DeleteKFromEndSpec extends Specification {
    def 'works for last'() {
        given:
        def p = Node.listOf('a', 'b', 'c', 'd')

        when:
        def q = DeleteKFromEnd.given(p, 0) 

        then:
        Node.toString(q) == '[a, b, c]'
    }

    def 'works for internal'() {
        given:
        def p = Node.listOf('a', 'b', 'c', 'd')

        when:
        def q = DeleteKFromEnd.given(p, 1) 

        then:
        Node.toString(q) == '[a, b, d]'
    }

    def 'works for internal again'() {
        given:
        def p = Node.listOf('a', 'b', 'c', 'd')

        when:
        def q = DeleteKFromEnd.given(p, 2) 

        then:
        Node.toString(q) == '[a, c, d]'
    }

    def 'works for beginning'() {
        given:
        def p = Node.listOf('a', 'b', 'c', 'd')

        when:
        def q = DeleteKFromEnd.given(p, 3) 

        then:
        Node.toString(q) == '[b, c, d]'
    }
}

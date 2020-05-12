package epi.lists

import spock.lang.*
import epi.lists.Node
import epi.lists.DeleteInPlace

class DeleteInPlaceSpec extends Specification {
    def 'works for last'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i')

        when:
        DeleteInPlace.atInternal(p.next().next()) 

        then:
        Node.toString(p) == '[a, c, g, i]'
    }
}

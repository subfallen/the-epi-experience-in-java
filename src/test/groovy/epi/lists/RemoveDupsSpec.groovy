package epi.lists

import spock.lang.*
import epi.lists.Node
import epi.lists.RemoveDups

class RemoveDupsSpec extends Specification {
    def 'works as expected'() {
        given:
        def p = Node.listOf('a', 'a', 'c', 'e', 'e', 'e', 'e', 'g', 'i', 'i')

        when:
        RemoveDups.from(p)

        then:
        Node.toString(p) == '[a, c, e, g, i]'
    }
}

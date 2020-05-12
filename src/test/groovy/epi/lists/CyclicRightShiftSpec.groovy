package epi.lists

import spock.lang.*
import epi.lists.Node
import epi.lists.CylicRightShift

class CylicRightShiftSpec extends Specification {
    def 'works as expected'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i')

        when:
        def q = CylicRightShift.appliedTo(p, 3)

        then:
        Node.toString(q) == '[e, g, i, a, c]'
    }
}

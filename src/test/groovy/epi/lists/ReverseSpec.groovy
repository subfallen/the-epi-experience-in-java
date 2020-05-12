package epi.lists

import spock.lang.*
import epi.lists.Node
import static epi.lists.Reverse.*

class ReverseSpec extends Specification {
    def 'works'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i')

        when:
        def q = Reverse.reverse(p)

        then:
        '[i, g, e, c, a]' == Node.toString(q)
    }
}

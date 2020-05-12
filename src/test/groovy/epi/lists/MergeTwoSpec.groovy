package epi.lists

import spock.lang.*
import epi.lists.Node
import static epi.lists.MergeTwo.*

class MergeTwoSpec extends Specification {
    def 'works'() {
        given:
        def p = Node.listOf('a', 'c', 'e')
        def q = Node.listOf('b', 'd', 'f', 'g', 'h')

        when:
        def merged = merge(p, q)
        and:
        def repr = Node.toString(merged)

        then:
        '[a, b, c, d, e, f, g, h]' == repr 
    }
}

package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils
import spock.lang.*
import epi.bintrees.TreeFromTraversals
import epi.trees.TreeNode
import static epi.trees.TreeUtils.*

class ExteriorSpec extends Specification {
    def 'works for the book'() {
        given:
        def expected = [314, 6, 271, 28, 0, 17, 641, 257, 28, 271, 6]

        when:
        def actual = Exterior.of(bintreeEpiExample()).collect { it.value() }

        then:
        actual == expected 
    }
}

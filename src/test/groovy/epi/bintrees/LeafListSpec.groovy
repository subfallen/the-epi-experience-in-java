package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils
import spock.lang.*
import epi.bintrees.TreeFromTraversals
import epi.trees.TreeNode
import static epi.trees.TreeUtils.*

class LeafListSpec extends Specification {
    def 'works for the book'() {
        given:
        def expected = [28, 0, 17, 641, 257, 28]

        when:
        def actual = LeafList.forTree(bintreeEpiExample()).collect { it.value() }

        then:
        actual == expected 
    }
}





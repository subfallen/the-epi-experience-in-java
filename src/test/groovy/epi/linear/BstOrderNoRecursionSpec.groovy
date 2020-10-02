package epi.linear

import spock.lang.*
import epi.linear.BstOrderNoRecursion
import epi.trees.TreeNode
import epi.trees.TreeUtils

class BstOrderNoRecursionSpec extends Specification {
    def 'has expected order'() {
        given:
        def elements = [1, 2, 3, 4, 5, 6]
        def tree = TreeUtils.bstFrom(elements)

        when:
        def inOrder = BstOrderNoRecursion.orderedValues(tree)

        then:
        inOrder == elements
    }
}

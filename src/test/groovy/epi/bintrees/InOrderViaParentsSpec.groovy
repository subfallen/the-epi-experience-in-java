package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils
import spock.lang.*
import epi.bintrees.SuccessorViaParents
import epi.trees.TreeNode
import static epi.trees.TreeUtils.*

class InOrderViaParentsSpec extends Specification {
    def 'works for the book'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        InOrderViaParents.inorder(tree) == epiInOrder()
    }
}




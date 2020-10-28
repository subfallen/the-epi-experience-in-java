package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils

import spock.lang.*
import epi.bintrees.BalanceCheck
import epi.trees.TreeNode
import epi.trees.TreeUtils

class BalanceCheckSpec extends Specification {
    def 'perfect is balanced'() {
        given:
        def tree = TreeUtils.perfect(2)

        expect:
        BalanceCheck.isBalanced(tree)        
    }

    def 'example is imbalanced'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        !BalanceCheck.isBalanced(tree)        
    }
}

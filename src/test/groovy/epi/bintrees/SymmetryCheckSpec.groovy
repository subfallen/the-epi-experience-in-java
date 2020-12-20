package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils

import spock.lang.*
import epi.bintrees.SymmetryCheck
import epi.trees.TreeNode
import epi.trees.TreeUtils

class SymmetryCheckSpec extends Specification {
    def 'perfect is symmetric with same values'() {
        given:
        def tree = TreeUtils.perfect(3, { ignore -> 42 })

        expect:
        SymmetryCheck.isSymmetric(tree)        
    }

    def 'perfect isnt symmetric with different values'() {
        given:
        def tree = TreeUtils.perfect(3)

        expect:
        !SymmetryCheck.isSymmetric(tree)        
    }
}

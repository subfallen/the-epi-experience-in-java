package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils
import spock.lang.*
import epi.bintrees.SuccessorViaParents
import epi.trees.TreeNode
import static epi.trees.TreeUtils.*

class SuccessorViaParentsSpec extends Specification {
    def 'P has no successor'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        SuccessorViaParents.successor(epiNodeP(tree)) == null
    }

    def 'M succeeded by K'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        SuccessorViaParents.successor(epiNodeM(tree)) == epiNodeK(tree)
    }

    def 'A succeeded by J'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        SuccessorViaParents.successor(tree) == epiNodeJ(tree)
    }

    def 'B succeeded by F'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        SuccessorViaParents.successor(epiNodeB(tree)) == epiNodeF(tree)
    }

    def 'E succeeded by B'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        SuccessorViaParents.successor(epiNodeE(tree)) == epiNodeB(tree)
    }
}



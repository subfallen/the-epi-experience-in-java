package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils

import spock.lang.*
import epi.bintrees.LcaViaParents
import epi.trees.TreeNode
import epi.trees.TreeUtils
import static epi.trees.TreeUtils.*

class LcaViaParentsSpec extends Specification {
    def 'from the book'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        LcaViaParents.lcaViaParents(epiNodeM(tree), epiNodeN(tree)) == epiNodeK(tree)
    }

    def 'again from the book'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        LcaViaParents.lcaViaParents(epiNodeD(tree), epiNodeP(tree)) == tree
    }
}

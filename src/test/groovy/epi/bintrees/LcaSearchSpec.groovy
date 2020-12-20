package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils

import spock.lang.*
import epi.bintrees.LcaSearch
import epi.trees.TreeNode
import epi.trees.TreeUtils
import static epi.trees.TreeUtils.*

class LcaSearchSpec extends Specification {
    def 'from the book'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        LcaSearch.lca(tree, epiNodeM(tree), epiNodeN(tree)) == epiNodeK(tree)
    }

    def 'again from the book'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        LcaSearch.lca(tree, epiNodeD(tree), epiNodeP(tree)) == tree
    }
}

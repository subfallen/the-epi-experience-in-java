package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils

import spock.lang.*
import epi.bintrees.KthNodeViaMeta
import epi.trees.TreeNode
import epi.trees.TreeUtils

class KthNodeViaMetaSpec extends Specification {
    def '1st is 28'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        KthNodeViaMeta.kth(tree, 1) == 28
    }

    def '8th is 314'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        KthNodeViaMeta.kth(tree, 8) == 314
    }

    def '10th is 401'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        KthNodeViaMeta.kth(tree, 10) == 401
    }

    def '16th is 28'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        KthNodeViaMeta.kth(tree, 16) == 28
    }
}


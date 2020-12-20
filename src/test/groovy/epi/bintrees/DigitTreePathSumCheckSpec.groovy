package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils

import spock.lang.*
import epi.bintrees.DigitTreePathSumCheck
import epi.trees.TreeNode
import epi.trees.TreeUtils

class DigitTreePathSumCheckSpec extends Specification {
    def 'example has 591'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        DigitTreePathSumCheck.hasPathNumsSum(tree, 591)
    }

    def 'example hasnt 591_000'() {
        given:
        def tree = TreeUtils.bintreeEpiExample()

        expect:
        !DigitTreePathSumCheck.hasPathNumsSum(tree, 591_000)
    }
}

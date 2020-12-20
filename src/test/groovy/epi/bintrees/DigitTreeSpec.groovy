package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils

import spock.lang.*
import epi.bintrees.DigitTree
import epi.trees.TreeNode
import epi.trees.TreeUtils
import static epi.trees.TreeUtils.*

class DigitTreeSpec extends Specification {
    def 'from the book'() {
        given:
        def tree = digitsBintree()
        and:
        int expected = 0b1000 + 0b1001 + 0b10110 + 0b110011 + 0b11000 + 0b1100

        expect:
        DigitTree.pathNumsSum(tree, 0) == expected
    }
}

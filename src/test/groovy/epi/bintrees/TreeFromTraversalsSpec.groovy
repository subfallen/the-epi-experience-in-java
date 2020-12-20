package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils
import spock.lang.*
import epi.bintrees.TreeFromTraversals
import epi.trees.TreeNode
import static epi.trees.TreeUtils.*

class TreeFromTraversalsSpec extends Specification {
    def 'works for the book'() {
        given:
        def inorder = ['F', 'B', 'A', 'E', 'H', 'C', 'D', 'I', 'G']
        and:
        def preorder = ['H', 'B', 'F', 'E', 'A', 'C', 'D', 'G', 'I']

        when:
        def recon = TreeFromTraversals.from(inorder, preorder)

        then:
        valuesMatch(recon, traversalExample())
    }
}




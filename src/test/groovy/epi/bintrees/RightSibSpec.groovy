package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils
import spock.lang.*
import epi.bintrees.TreeFromTraversals
import epi.trees.TreeNode
import static epi.trees.TreeUtils.*

class RightSibSpec extends Specification {
    def 'works for the book'() {
        given:
        def tree = perfect(4)

        when:
        RightSib.set(tree)

        then:
        level(tree) == [0] 
        level((tree = tree.left())) == [1, 2] 
        level((tree = tree.left())) == [3, 4, 5, 6] 
        level((tree = tree.left())) == [7, 8, 9, 10, 11, 12, 13, 14] 
    }

    private List<Integer> level(TreeNode<Integer> leftMost) {
        List<Integer> l = new ArrayList<>()
        def p = leftMost
        while (p != null) {
            l << p.value()
            p = p.levelNext()
        }
        return l
    }
}


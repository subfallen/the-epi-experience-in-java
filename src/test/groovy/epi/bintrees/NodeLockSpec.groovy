package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils
import spock.lang.*
import epi.bintrees.TreeFromTraversals
import epi.trees.TreeNode
import static epi.trees.TreeUtils.*

class NodeLockSpec extends Specification {
    def 'locked root prohibits child lock'() {
        given:
        def tree = bintreeEpiExample()

        when:
        tree.lock()
        tree.left().lock()
        
        then:
        thrown IllegalStateException
    }

    def 'locked child prohibits root lock'() {
        given:
        def tree = bintreeEpiExample()

        when:
        tree.left().lock()
        tree.lock()
        
        then:
        thrown IllegalStateException
    }
}

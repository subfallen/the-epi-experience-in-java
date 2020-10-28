package epi.linear

import java.util.*
import spock.lang.*
import epi.linear.NodesByDepth
import static java.util.stream.Collectors.*;
import epi.trees.TreeNode
import static epi.trees.TreeNode.*
import static epi.trees.TreeUtils.*

class NodesByDepthSpec extends Specification {
    def 'handles misc case'() {
        given:
        def tree = bintreeEpiExample()

        when:
        def byDepth = NodesByDepth.from(tree)

        then:
        byDepth == [
            [314],
            [6, 6],
            [271, 561, 2, 271],
            [28, 0, 3, 1, 28],
            [17, 401, 257],
            [641]
        ]
    }
}

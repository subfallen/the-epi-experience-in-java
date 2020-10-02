package epi.linear

import spock.lang.*
import epi.linear.JumpOrder
import static epi.linear.JumpListNode.*;

class JumpOrderSpec extends Specification {
    def 'recursive ordering works'() {
        given:
        def dNode = new JumpListNode("d", NONE)
        def cNode = new JumpListNode("c", dNode)
        def bNode = new JumpListNode("b", cNode)
        def aNode = new JumpListNode("a", bNode)
        aNode.jump = cNode
        bNode.jump = dNode
        cNode.jump = bNode
        dNode.jump = dNode

        when:
        JumpOrder.jumpOrder(aNode) 

        then:
        aNode.assignedOrders() == [0, 2, 1, 3]
    }

    def 'iterative ordering works'() {
        given:
        def dNode = new JumpListNode("d", NONE)
        def cNode = new JumpListNode("c", dNode)
        def bNode = new JumpListNode("b", cNode)
        def aNode = new JumpListNode("a", bNode)
        aNode.jump = cNode
        bNode.jump = dNode
        cNode.jump = bNode
        dNode.jump = dNode

        when:
        JumpOrder.iterativeJumpOrder(aNode) 

        then:
        aNode.assignedOrders() == [0, 2, 1, 3]
    }
}

package epi.linear;

import java.util.*;

public class JumpListNode {
    public static final int NO_ORDER = -1;
    public static final JumpListNode NONE = null;

    public int order = NO_ORDER;
    public String name;
    public JumpListNode next, jump = NONE;

    public JumpListNode(String name, JumpListNode next) {
        this.name = name;
        this.next = next;
    }

    public List<Integer> assignedOrders() {
        List<Integer> orders = new ArrayList<>();
        orders.add(order);
        var p = next;
        while (p != NONE) {
            orders.add(p.order);
            p = p.next;
        }
        return orders;
    }
}

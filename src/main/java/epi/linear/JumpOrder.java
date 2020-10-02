package epi.linear;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.*;
import java.util.regex.*;
import java.util.Collections;
import static java.util.stream.Collectors.*;
import epi.trees.TreeNode;
import static epi.linear.JumpListNode.*;

public class JumpOrder {
    public static void jumpOrder(JumpListNode root) {
        jo(root, new AtomicInteger(0));
    }

    private static void jo(JumpListNode n, AtomicInteger order) {
        if (n == NONE) {
            return;
        }
        System.out.println("Now @ " + n.name);
        n.order = order.getAndIncrement();
        if (n.jump.order == NO_ORDER) {
            jo(n.jump, order);
        }
        if (n.next != NONE && n.next.order == NO_ORDER) {
            jo(n.next, order);
        }
    }

    public static void iterativeJumpOrder(JumpListNode root) {
        Deque<JumpListNode> reachableButUnordered = new ArrayDeque<>();

        reachableButUnordered.add(root);

        int order = 0;
        while (!reachableButUnordered.isEmpty()) {
            var cur = reachableButUnordered.pop();
            if (cur.order == NO_ORDER) {
                cur.order = order++;
            } else {
                continue;
            }
            if (cur.next != NONE) {
                reachableButUnordered.push(cur.next);
            }
            reachableButUnordered.push(cur.jump);
        }
    }
}

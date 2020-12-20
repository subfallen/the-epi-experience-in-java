package epi.bintrees;

import java.util.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

import static epi.trees.TreeUtils.*;

public class SuccessorViaParents {
    public static TreeNode<Integer> successor(TreeNode<Integer> node) {
        TreeNode<Integer> p = null;
        if ((p = node.right()) != null) {
            while (p.left() != null) {
                p = p.left();
            }
        } else {
            p = node.parent();
            while (p != null && node != p.left()) {
                node = p;
                p = p.parent();
            }
        }
        return p;
    }
}


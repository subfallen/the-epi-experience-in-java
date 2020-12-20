package epi.bintrees;

import java.util.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

import static epi.trees.TreeUtils.*;

public class KthNodeViaMeta {
    public static int kth(TreeNode<Integer> root, int k) {
        int left;
        while ((left = numOnLeft(root)) != (k - 1)) {
            if (left >= k) {
                root = root.left();
            } else {
                root = root.right();
                k -= (left + 1);
            }
        }
        return root.value();
    }

    private static int numOnLeft(TreeNode<Integer> node) {
        return Optional.ofNullable(node.left()).map(TreeNode<Integer>::nodesInSubTree).orElse(0);
    }
}


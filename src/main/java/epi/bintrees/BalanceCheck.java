package epi.bintrees;

import epi.trees.TreeNode;
import static epi.trees.TreeNode.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class BalanceCheck {
    public static boolean isBalanced(TreeNode root) {
        var answer = new AtomicBoolean(true);
        height(root, answer);
        return answer.get();
    }

    private static int height(TreeNode node, AtomicBoolean isBalanced) {
        if (node == null) {
            return -1;
        } else {
            int l = height(node.left(), isBalanced), r = height(node.right(), isBalanced);
            if (Math.abs(l - r) > 1) {
                isBalanced.set(false);
            }
            return 1 + Math.max(l, r);
        }
    }
}

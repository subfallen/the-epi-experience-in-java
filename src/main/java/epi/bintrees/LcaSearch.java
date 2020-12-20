package epi.bintrees;

import epi.trees.TreeNode;
import java.util.Optional;
import static epi.trees.TreeNode.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LcaSearch {
    public static TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        } else if (root.equals(a) || root.equals(b)) {
            return root;
        } else {
            var lCand = lca(root.left(), a, b);
            var rCand = lca(root.right(), a, b);
            if (lCand != null && rCand != null) {
                return root;
            } else {
                return Optional.ofNullable(lCand).orElse(rCand);
            }
        }
    }
}

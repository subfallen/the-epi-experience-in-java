package epi.bintrees;

import java.util.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

import static epi.trees.TreeUtils.*;

public class LeafList {
    public static <T> List<TreeNode<T>> forTree(TreeNode<T> root) {
        LlConstruct<T> ctx = new LlConstruct<>(root);
        return ctx.ans;
    }

    static class LlConstruct<T> {
        List<TreeNode<T>> ans = new ArrayList<>();

        public LlConstruct(TreeNode<T> root) {
            dfs(root);
        }

        private void dfs(TreeNode<T> n) {
            if (n == null) {
                return;
            } else if (n.left() == n.right()) {
                ans.add(n);
            } else {
                dfs(n.left());
                dfs(n.right());
            }
        }
    }
}


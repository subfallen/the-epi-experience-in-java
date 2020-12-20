package epi.bintrees;

import java.util.*;
import java.util.function.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

import static epi.trees.TreeUtils.*;

public class Exterior {
    public static <T> List<TreeNode<T>> of(TreeNode<T> root) {
        return new ExtContext<>(root).ans;
    }

    static class ExtContext<T> {
        List<TreeNode<T>> ans = new ArrayList<>();

        public ExtContext(TreeNode<T> root) {
            ans.add(root);
            addSide(root.left(), TreeNode<T>::left, ans);
            if (root.left() != root.right()) {
                dfs(root);
            }
            List<TreeNode<T>> rightSide = new ArrayList<>();
            addSide(root.right(), TreeNode<T>::right, rightSide);
            Collections.reverse(rightSide);
            ans.addAll(rightSide);
        }

        private void addSide(
                TreeNode<T> n, 
                UnaryOperator<TreeNode<T>> child,
                List<TreeNode<T>> side
        ) {
            if (n == null) {
                return;
            }

            if (child.apply(n) != null) {
                side.add(n);
                addSide(child.apply(n), child, side);
            }
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


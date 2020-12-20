package epi.bintrees;

import java.util.*;
import java.util.function.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

import static epi.trees.TreeUtils.*;

public class RightSib {
    public static <T> void set(TreeNode<T> perfectRoot) {
        if (perfectRoot == null) {
            return;
        }

        Deque<TreeNode<T>> q = new ArrayDeque<>();
        q.offer(perfectRoot);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            TreeNode<T> prior = null;
            while (levelSize-- > 0) {
                var next = q.poll();
                if (prior != null) {
                    prior.setLevelNext(next);
                }
                prior = next;
                if (next.left() != null && next.right() != null) {
                    q.offer(next.left());
                    q.offer(next.right());
                }
            }
        }
    }
}



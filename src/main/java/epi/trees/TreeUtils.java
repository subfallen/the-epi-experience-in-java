package epi.trees;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Collections;
import epi.trees.TreeNode;
import static epi.trees.TreeNode.*;


public class TreeUtils {
    public static <T extends Comparable> TreeNode<T> bstFrom(List<T> elements) {
        Collections.sort(elements);
        return bstFromOrdered(elements, 0, elements.size() - 1);    
    }

    private static <T> TreeNode<T> bstFromOrdered(List<T> elements, int lo, int hi) {
        if (hi < lo) {
            return TreeNode.NONE;
        } else if (lo == hi) {
            return TreeNode.leaf(elements.get(lo));
        } else {
            int mid = lo + (hi - lo) / 2;
            var left = bstFromOrdered(elements, lo, mid - 1);
            var right = bstFromOrdered(elements, mid + 1, hi);
            return TreeNode.internal(elements.get(mid), left, right);
        }
    }

    public static <T> List<T> inOrder(TreeNode<T> root) {
        if (root == TreeNode.NONE) {
            return Collections.emptyList();
        } else {
            var smaller = inOrder(root.left());
            var larger = inOrder(root.right());
            return Stream.of(smaller, List.of(root.value()), larger)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        }
    }

    public static TreeNode<Integer> perfect(int depth) {
        return perfect(depth, i -> i);
    }

    public static TreeNode<Integer> perfect(int depth, IntUnaryOperator gen) {
        TreeNode<Integer> root = leaf(gen.applyAsInt(0));
        if (depth == 0) {
            return root;
        }

        Deque<TreeNode<Integer>> q = new ArrayDeque<>();
        q.offer(root);
        int nextNodeId = 1, nextDepth = 1, nodesThisDepth = 1;
        while (nextDepth <= depth) {
            for (int i = 0; i < nodesThisDepth; i++) {
                var newInternal = q.poll();
                TreeNode<Integer> left = leaf(gen.applyAsInt(nextNodeId++));
                TreeNode<Integer> right = leaf(gen.applyAsInt(nextNodeId++));
                newInternal.setLeft(left);
                newInternal.setRight(right);
                if (nextDepth < depth) {
                    q.offer(left);
                    q.offer(right);
                }
            }
            nextDepth++;
            nodesThisDepth *= 2;
        }
        return root;
    }

    public static TreeNode<Integer> bintreeEpiExample() {
        TreeNode<Integer> D = leaf(28);
        TreeNode<Integer> E = leaf(0);
        TreeNode<Integer> H = leaf(17);
        TreeNode<Integer> M = leaf(641);
        TreeNode<Integer> N = leaf(257);
        TreeNode<Integer> P = leaf(28);
        TreeNode<Integer> C = internal(271, D, E);
        TreeNode<Integer> G = internal(3, H, NONE);
        TreeNode<Integer> F = internal(561, NONE, G);
        TreeNode<Integer> L = internal(401, NONE, M);
        TreeNode<Integer> O = internal(271, NONE, P);
        TreeNode<Integer> K = internal(1, L, N);
        TreeNode<Integer> J = internal(2, NONE, K);
        TreeNode<Integer> I = internal(6, J, O);
        TreeNode<Integer> B = internal(6, C, F);
        TreeNode<Integer> A = internal(314, B, I);

        return A;
    }
}

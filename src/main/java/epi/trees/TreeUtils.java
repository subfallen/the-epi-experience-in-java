package epi.trees;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Collections;
import epi.trees.TreeNode;
import static epi.trees.TreeNode.*;


public class TreeUtils {
    public static boolean isLeaf(TreeNode<?> node) {
        return node.left() == null && node.right() == null;
    }

    public static <T extends Comparable> TreeNode<T> bstFrom(List<T> elements) {
        Collections.sort(elements);
        return bstFromOrdered(elements, 0, elements.size() - 1);    
    }

    private static <T extends Comparable> TreeNode<T> bstFromOrdered(List<T> elements, int lo, int hi) {
        if (hi < lo) {
            return null;
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
        if (root == null) {
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

    public static TreeNode<Integer> digitsBintree() {
        TreeNode<Integer> M = leaf(1);
        TreeNode<Integer> N = leaf(0);
        TreeNode<Integer> L = internal(1, null, M);
        TreeNode<Integer> K = internal(0, L, N);
        TreeNode<Integer> J = internal(0, null, K);
        TreeNode<Integer> P = leaf(0);
        TreeNode<Integer> O = internal(0, null, P);
        TreeNode<Integer> I = internal(1, J, O);
        TreeNode<Integer> H = leaf(0);
        TreeNode<Integer> G = internal(1, H, null);
        TreeNode<Integer> F = internal(1, null, G);
        TreeNode<Integer> D = leaf(0);
        TreeNode<Integer> E = leaf(1);
        TreeNode<Integer> C = internal(0, D, E);    
        TreeNode<Integer> B = internal(0, C, F);    
        TreeNode<Integer> A = internal(1, B, I);    
        return A;
    }

    public static TreeNode<String> traversalExample() {
        TreeNode<String> F = leaf("F");
        TreeNode<String> A = leaf("A");
        TreeNode<String> E = internal("E", A, null);
        TreeNode<String> B = internal("B", F, E);
        TreeNode<String> I = leaf("I");
        TreeNode<String> G = internal("G", I, null);
        TreeNode<String> D = internal("D", null, G);
        TreeNode<String> C = internal("C", null, D);
        TreeNode<String> H = internal("H", B, C);
        return H;
    }

    public static <T> boolean valuesMatch(TreeNode<T> a, TreeNode<T> b) {
        if (a == null && b == null) {
            return true;
        } 
        if (a == null || b == null) {
            return false;
        }
        return Objects.equals(a.value(), b.value()) && 
            valuesMatch(a.left(), b.left()) &&
            valuesMatch(a.right(), b.right());
    }

    public static TreeNode<Integer> bintreeEpiExample() {
        TreeNode<Integer> D = leaf(28);
        D.setNodesInSubTree(1);
        TreeNode<Integer> E = leaf(0);
        E.setNodesInSubTree(1);
        TreeNode<Integer> H = leaf(17);
        H.setNodesInSubTree(1);
        TreeNode<Integer> M = leaf(641);
        M.setNodesInSubTree(1);
        TreeNode<Integer> N = leaf(257);
        N.setNodesInSubTree(1);
        TreeNode<Integer> P = leaf(28);
        P.setNodesInSubTree(1);
        TreeNode<Integer> C = internal(271, D, E);
        C.setNodesInSubTree(3);
        D.setParent(C);
        E.setParent(C);
        TreeNode<Integer> G = internal(3, H, null);
        G.setNodesInSubTree(2);
        H.setParent(G);
        TreeNode<Integer> F = internal(561, null, G);
        F.setNodesInSubTree(3);
        G.setParent(F);
        TreeNode<Integer> L = internal(401, null, M);
        L.setNodesInSubTree(2);
        M.setParent(L);
        TreeNode<Integer> O = internal(271, null, P);
        O.setNodesInSubTree(2);
        P.setParent(O);
        TreeNode<Integer> K = internal(1, L, N);
        K.setNodesInSubTree(4);
        L.setParent(K);
        N.setParent(K);
        TreeNode<Integer> J = internal(2, null, K);
        J.setNodesInSubTree(5);
        K.setParent(J);
        TreeNode<Integer> I = internal(6, J, O);
        I.setNodesInSubTree(8);
        J.setParent(I);
        O.setParent(I);
        TreeNode<Integer> B = internal(6, C, F);
        B.setNodesInSubTree(7);
        C.setParent(B);
        F.setParent(B);
        TreeNode<Integer> A = internal(314, B, I);
        A.setNodesInSubTree(16);
        I.setParent(A);
        B.setParent(A);

        return A;
    }

    public static TreeNode<Integer> epiNodeM(TreeNode<Integer> root) {
        return root.right().left().right().left().right();
    }

    public static TreeNode<Integer> epiNodeF(TreeNode<Integer> root) {
        return root.left().right();
    }

    public static TreeNode<Integer> epiNodeJ(TreeNode<Integer> root) {
        return root.right().left();
    }

    public static TreeNode<Integer> epiNodeN(TreeNode<Integer> root) {
        return root.right().left().right().right();
    }

    public static TreeNode<Integer> epiNodeK(TreeNode<Integer> root) {
        return root.right().left().right();
    }

    public static TreeNode<Integer> epiNodeB(TreeNode<Integer> root) {
        return root.left();
    }

    public static TreeNode<Integer> epiNodeI(TreeNode<Integer> root) {
        return root.right();
    }

    public static TreeNode<Integer> epiNodeD(TreeNode<Integer> root) {
        return root.left().left().left();
    }

    public static TreeNode<Integer> epiNodeE(TreeNode<Integer> root) {
        return root.left().left().right();
    }

    public static TreeNode<Integer> epiNodeP(TreeNode<Integer> root) {
        return root.right().right().right();
    }

    public static TreeNode<Integer> epiNodeH(TreeNode<Integer> root) {
        return root.left().right().right().left();
    }

    public static TreeNode<Integer> epiNodeG(TreeNode<Integer> root) {
        return root.left().right().right();
    }

    public static List<Integer> epiInOrder() {
        return List.of(
                28, 271, 0, 6, 561, 17, 3,
                314,
                2, 401, 641, 1, 257, 6, 271, 28
        );
    }
}

package epi.trees;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Collections;
import epi.trees.TreeNode;

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
}

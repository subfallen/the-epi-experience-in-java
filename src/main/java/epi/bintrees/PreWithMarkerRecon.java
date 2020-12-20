package epi.bintrees;

import java.util.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

import static epi.trees.TreeUtils.*;

public class PreWithMarkerRecon {
    public static <T> TreeNode<T> from(List<T> premarked) {
        return rooted(premarked, 0).getKey();    
    }

    private static <T> Map.Entry<TreeNode<T>, Integer> rooted(List<T> premarked, int start) {
        var rootVal = premarked.get(start);
        if (rootVal == null) {
            return new AbstractMap.SimpleImmutableEntry<>(null, 1);
        } else {
            TreeNode<T> root = new TreeNode<>(rootVal);
            Map.Entry<TreeNode<T>, Integer> left = rooted(premarked, start + 1);
            Map.Entry<TreeNode<T>, Integer> right = rooted(premarked, start + 1 + left.getValue());
            root.setLeft(left.getKey());
            root.setRight(right.getKey());
            return new AbstractMap.SimpleImmutableEntry<>(root, 1 + left.getValue() + right.getValue());
        }
    }
}

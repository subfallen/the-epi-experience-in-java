package epi.linear;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.*;
import java.util.stream.*;
import java.util.regex.*;
import java.util.Collections;
import static java.util.stream.Collectors.*;
import epi.trees.TreeNode;

public class BstOrderNoRecursion {
    enum TraversalState { NEITHER_CHILD, LEFT_CHILD, BOTH_CHILDREN }

    public static <T> List<T> orderedValues(TreeNode<T> root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<T> values = new ArrayList<>();
        Deque<TreeNode<T>> traversedNotValued = new ArrayDeque<>();
        TreeNode<T> nextNode = root;

        while (nextNode != null || !traversedNotValued.isEmpty()) {
            if (nextNode != null) {
                traversedNotValued.push(nextNode);
                nextNode = nextNode.left();
            } else {
                var prevNode = traversedNotValued.pop();
                values.add(prevNode.value());
                nextNode = prevNode.right();
            }
        }

        return values;
    }
}

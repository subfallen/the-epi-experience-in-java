package epi.bintrees;

import java.util.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

import static epi.trees.TreeUtils.*;

public class DigitTreePathSumCheck {
    public static boolean hasPathNumsSum(TreeNode<Integer> root, int target) {
        if (root == null) {
            return false;
        } else if (isLeaf(root)) {
            return root.value() == target;
        } else {
            var updated = target - root.value();
            return hasPathNumsSum(root.left(), updated) || hasPathNumsSum(root.right(), updated);
        }
    }

}

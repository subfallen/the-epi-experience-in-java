package epi.bintrees;

import java.util.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

public class DigitTree {
    public static int pathNumsSum(TreeNode<Integer> root, int prefix) {
        if (root == null) {
            return 0;
        }
        var here = (prefix << 1) + root.value(); 
        if (root.left() == null && root.right() == null) {
            System.out.println(Integer.toString(here, 2));
            return here;
        } else {
            return pathNumsSum(root.left(), here) + pathNumsSum(root.right(), here);
        }
    }
}

package epi.bintrees;

import java.util.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

import static epi.trees.TreeUtils.*;

public class TreeFromTraversals {
    public static <T> TreeNode<T> from(List<T> inorder, List<T> preorder) {
        Map<T, Integer> inPos = new HashMap<>();
        for (int i = 0, n = inorder.size(); i < n; i++) {
            inPos.put(inorder.get(i), i);
        }
        return fromMeta(inorder, preorder, inPos, 0);
    }

    private static <T> TreeNode<T> fromMeta(
            List<T> in, 
            List<T> pre,
            Map<T, Integer> inPos,
            int offset
    ) {
        int n = in.size();
        if (n == 1) { 
            return TreeNode.leaf(in.get(0)); 
        }

        var rootVal = pre.get(0);
        var rootInLoc = inPos.get(rootVal) - offset;
        int leftSize = rootInLoc, rightSize = n - 1 - leftSize;    
       
        var root = new TreeNode(rootVal);
        if (leftSize > 0) {
            root.setLeft(
                    fromMeta(
                        in.subList(0, leftSize), 
                        pre.subList(1, 1 + leftSize), 
                        inPos, 
                        offset));
        }
        if (rightSize > 0) {
            root.setRight(
                    fromMeta(
                        in.subList(rootInLoc + 1, n),
                        pre.subList(1 + leftSize, n),
                        inPos,
                        offset + leftSize + 1));
        }
        return root;
    }
}



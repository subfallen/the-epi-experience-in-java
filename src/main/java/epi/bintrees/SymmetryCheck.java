package epi.bintrees;

import epi.trees.TreeNode;
import static epi.trees.TreeNode.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SymmetryCheck {
    public static boolean isSymmetric(TreeNode root) {
        return root == null || areMirrorImages(root.left(), root.right());
    }

    private static boolean areMirrorImages(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } 
        return a.value().equals(b.value()) && 
            areMirrorImages(a.left(), b.right()) &&
            areMirrorImages(a.right(), b.left());
    }
}

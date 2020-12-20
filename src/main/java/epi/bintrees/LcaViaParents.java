package epi.bintrees;

import java.util.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

public class LcaViaParents {
    public static TreeNode lcaViaParents(TreeNode a, TreeNode b) {
        Set<TreeNode> aParents = new HashSet<>();
        while (a != null) {
            aParents.add(a);
            a = a.parent();
        }

        while (!aParents.contains(b)) {
            b = b.parent();
        }
        return b;
    }
}

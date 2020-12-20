package epi.bintrees;

import java.util.*;
import epi.trees.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

import static epi.trees.TreeUtils.*;

public class InOrderViaParents {
    enum VisitType { DESC, FROM_LEFT, FROM_RIGHT }

    public static List<Integer> inorder(TreeNode<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        var visitType = VisitType.DESC;    
        while (root != null) {
            switch (visitType) {
                case FROM_LEFT:
                    ans.add(root.value());
                    if (root.right() != null) {
                        root = root.right();
                        visitType = VisitType.DESC;
                    } else {
                        visitType = VisitType.FROM_RIGHT;
                    } 
                    break;
                case FROM_RIGHT:
                    if (root.parent() != null) {
                        visitType = (root == root.parent().left()) 
                            ? VisitType.FROM_LEFT : VisitType.FROM_RIGHT;
                    } 
                    root = root.parent();
                    break;
                case DESC:
                    if (root.left() != null) {
                        root = root.left();
                    } else {
                        visitType = VisitType.FROM_LEFT;
                    }
                    break;
            }
        }
        return ans;
    }
}



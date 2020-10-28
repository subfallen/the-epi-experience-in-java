package epi.linear;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.*;
import java.util.regex.*;
import java.util.Collections;
import static java.util.stream.Collectors.*;
import epi.trees.TreeNode;
import static epi.trees.TreeNode.*;

public class NodesByDepth {
    public static List<List<Integer>> from(TreeNode<Integer> root) {
        List<List<Integer>> l = new ArrayList<>();
        Deque<Map.Entry<TreeNode<Integer>, Integer>> queue = new ArrayDeque<>();
        int curLvl = 0;
        List<Integer> thisLvl = new ArrayList<>();
        queue.offer(entry(root, curLvl));
        while (!queue.isEmpty()) {
            var next = queue.poll();
            var node = next.getKey();
            int lvlHere = next.getValue();     
            if (node.left() != NONE) {
                queue.offer(entry(node.left(), lvlHere + 1));
            }
            if (node.right() != NONE) {
                queue.offer(entry(node.right(), lvlHere + 1));
            }
            if (lvlHere > curLvl) {
                l.add(new ArrayList<>(thisLvl));
                curLvl = lvlHere;
                thisLvl.clear();
            } 
            thisLvl.add(node.value());
        }
        l.add(thisLvl);
        return l;
    }

    private static Map.Entry<TreeNode<Integer>, Integer> entry(TreeNode<Integer> node, int lvl) {
        return new AbstractMap.SimpleImmutableEntry<>(node, lvl);
    }
}

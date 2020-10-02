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

public class SunsetViews {
    public static List<Integer> idsWithView(List<Integer> heights) {
        int n = heights.size();
        if (n == 0) {
            return Collections.emptyList();
        }
        Deque<Map.Entry<Integer, Integer>> sunsetViews = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int height = heights.get(i);
            while (!sunsetViews.isEmpty() && sunsetViews.peek().getValue() <= height) {
                sunsetViews.pop();
            }
            sunsetViews.push(new AbstractMap.SimpleImmutableEntry<>(i, height));
        }
        return sunsetViews.stream().map(Map.Entry::getKey).collect(toList());
    }
}

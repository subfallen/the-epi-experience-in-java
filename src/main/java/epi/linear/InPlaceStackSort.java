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

public class InPlaceStackSort {
    public static void inPlaceSort(Deque<Integer> stack) {
        int n = stack.size();
        for (int i = 1; i <= n - 1; i++) {
            int top = stack.pop();
            insertIn(stack, top, n - 1 - i);
        }
    }

    private static void insertIn(Deque<Integer> stack, int v, int leftToSkip) {
        if (stack.isEmpty()) {
            stack.push(v);
        } else {
            if (leftToSkip > 0 || v < stack.peek()) {
                int here = stack.pop();
                insertIn(stack, v, leftToSkip - 1);
                stack.push(here);
            } else {
                stack.push(v);
            }
        }
    }
}

package epi.heaps;

import java.util.*;
import static java.util.Comparator.*;

public class FindKSmallest {
    public static List<Integer> smallestK(List<Integer> l, int k) {
        Queue<Integer> chosen = new PriorityQueue<>(reverseOrder());
        for (Integer i : l) {
            if (chosen.size() < k) {
                chosen.offer(i);
            } else if (i < chosen.peek()) {
                chosen.poll();
                chosen.offer(i);
            }
        }
        return new ArrayList<>(chosen);
    }
}


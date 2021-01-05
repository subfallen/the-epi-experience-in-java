package epi.heaps;

import java.util.*;
import static java.util.Comparator.*;

public class FinishAlmostSorted {
    public static List<Integer> finish(List<Integer> l, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, n = l.size(); i < n; i++) {
            pq.offer(l.get(i));
            if (i < k) {
                continue;
            }
            ans.add(pq.poll());
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        return ans;
    }
}

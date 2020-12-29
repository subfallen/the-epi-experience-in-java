package epi.heaps;

import java.util.*;
import static java.util.Comparator.*;

public class MultiwayMerge {
    @SafeVarargs
    public static <T extends Comparable<T>> List<T> merge(List<T>... parts) {
        List<T> whole = new ArrayList<>();
        int[] next = new int[parts.length];
        Queue<Map.Entry<T, Integer>> q = new PriorityQueue<>(comparing(Map.Entry<T, Integer>::getKey));
        for (int i = 0; i < next.length; i++) {
            if (0 < parts[i].size()) {
                q.offer(entry(parts[i].get(0), i));
            }
        }
        while (!q.isEmpty()) {
            var smol = q.poll();
            whole.add(smol.getKey());
            var which = smol.getValue();
            next[which]++;
            if (next[which] < parts[which].size()) {
                q.offer(entry(parts[which].get(next[which]), which));
            }
        }
        return whole;
    }

    private static <T extends Comparable<T>> Map.Entry<T, Integer> entry(T value, int index) {
        return new AbstractMap.SimpleImmutableEntry<>(value, index);
    }
}

package epi.heaps;

import java.util.*;
import static java.util.Comparator.*;

public class FindKLargest {
    private static final Comparator<Integer> unnaturalOrder = 
        Comparator.<Integer>naturalOrder().reversed();

    public static int[] kLargest(int[] arrayHeap, int k) {
        final Comparator<Integer> byHeapValue = (i, j) -> 
            unnaturalOrder.compare(arrayHeap[i], arrayHeap[j]);
        
        if (k < 1) {  
            return new int[0];
        }

        final var ans = new int[k];
        var i = 0; 
        final Queue<Integer> indexHeap = new PriorityQueue<>(byHeapValue);
        indexHeap.add(0);
        while (i < k) {
            var nextLargest = indexHeap.poll();
            if (2 * nextLargest + 1 < arrayHeap.length) {
                indexHeap.add(2 * nextLargest + 1);
            }
            if (2 * nextLargest + 1 < arrayHeap.length) {
                indexHeap.add(2 * nextLargest + 2);
            }
            ans[i++] = arrayHeap[nextLargest];
        }

        return ans;
    }
}

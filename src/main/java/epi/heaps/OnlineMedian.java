package epi.heaps;

import java.util.*;
import static java.util.Comparator.*;

public class OnlineMedian {
    Queue<Integer> lte = new PriorityQueue<>(reverseOrder());
    Queue<Integer> gte = new PriorityQueue<>();

    public void observe(int next) {
        if (lte.isEmpty() || next <= lte.peek()) {
            lte.offer(next);
        } else {
            gte.offer(next);
        }

        while (lte.size() < gte.size()) {
            lte.offer(gte.poll());
        }
        while (lte.size() > gte.size() + 1) {
            gte.offer(lte.poll());
        }
    }

    public double medianSoFar() {
        return lte.size() == gte.size() 
            ? 0.5 * (lte.peek() + gte.peek())
            : 1.0 * lte.peek();
    }
}

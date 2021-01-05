package epi.heaps;

import java.util.*;
import static java.util.Comparator.*;

public class IncDecSort {
    public static List<Integer> sortIncDec(List<Integer> l, int k) {
        int n = l.size();
        Run[] runs = new Run[k];
        int start = 0, curCmp = 1;
        for (int i = 1, j = 0; i < n && j < k; i++) {
            if (Integer.compare(l.get(i), l.get(i - 1)) != curCmp) {
                runs[j++] = new Run(l, start, i - 1, curCmp);
                start = i;
                curCmp *= -1;
            }
        }
        runs[k - 1] = new Run(l, start, n - 1, curCmp);

        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            pq.offer(new int[] { runs[i].next(), i });
        }
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            ans.add(top[0]);
            int from = top[1];
            if (runs[from].hasNext()) {
                pq.offer(new int[] { runs[from].next(), from });
            }
        }
        return ans;
    }

    static class Run {
        private final List<Integer> src;
        private final int l, r, dir;
        private int cur;

        Run(List<Integer> src, int l, int r, int dir) {
            assert Math.abs(dir) == 1;

            this.src = src;
            this.l = l;
            this.r = r;
            this.dir = dir;
            cur = (dir == 1) ? l : r;
        }

        boolean hasNext() {
            return cur != ((dir < 0) ? l : r) + dir;
        }

        int next() {
            if (!hasNext()) {
                throw new IllegalStateException("Nothing more to give!");
            }
            int ret = cur;
            cur += dir;
            return src.get(ret);
        }
        
        @Override
        public String toString() {
            return ((dir == 1) 
                ? String.format("%d->%d", l, r)
                : String.format("%d<-%d", l, r)) + " (cur=" + cur + ")";
        }
    }
}

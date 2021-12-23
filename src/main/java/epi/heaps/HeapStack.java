package epi.heaps;

import java.util.*;
import static java.util.Comparator.*;

public class HeapStack<T> {
    private static class IndexedItem<T> implements Comparable<IndexedItem<T>> {
        final T item;
        final int pos;

        IndexedItem(T item, int pos) {
            this.pos = pos;
            this.item = item;
        }

        public int compareTo(IndexedItem<T> that) {
            return Integer.compare(this.pos, that.pos);
        }
    }

    private int nextI = Integer.MAX_VALUE;
    private Queue<IndexedItem<T>> heap = new PriorityQueue<>();

    public void push(T item) {
        heap.offer(new IndexedItem<>(item, nextI--));
    }

    public T pop() {
        final var top = heap.poll();
        return (top == null ) ? null : top.item;
    }
}

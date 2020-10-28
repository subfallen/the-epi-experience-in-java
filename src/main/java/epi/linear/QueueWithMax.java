package epi.linear;

import java.util.*;
import java.util.stream.StreamSupport;
import static java.util.stream.Collectors.*;

public class QueueWithMax<T extends Comparable<T>> {
    Deque<T> delegate = new ArrayDeque<>();
    Deque<T> candMaxes = new ArrayDeque<>();

    public void offer(T elem) {
        delegate.offer(elem);
        while (!candMaxes.isEmpty()) {
            var lastCand = candMaxes.peekLast();
            if (lastCand.compareTo(elem) < 0) {
                candMaxes.pollLast();
            } else {
                break;
            }
        }
        candMaxes.offerLast(elem);
    }

    public T poll() {
        var ret = delegate.poll();
        if (ret != null) {
            if (ret.compareTo(candMaxes.peek()) == 0) {
                candMaxes.poll();
            }
        }
        return ret;
    }

    public T max() {
        return candMaxes.peek();
    }

    @Override
    public String toString() {
        return String.format(
                "Delegate: %s + CandMaxes: %s", 
                readable(delegate), 
                readable(candMaxes));
    }

    private String readable(Deque<T> d) {
        return "[" + StreamSupport.stream(d.spliterator(), false)
            .map(Object::toString)
            .collect(joining(", ")) + "]";
    }
}

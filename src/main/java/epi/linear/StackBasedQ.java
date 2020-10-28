package epi.linear;

import java.util.*;

public class StackBasedQ<T> {
    Deque<T> reversedSuffix = new ArrayDeque<>();
    Deque<T> prefix = new ArrayDeque<>();

    public void offer(T elem) {
        reversedSuffix.push(elem);
    }

    public T poll() {
        if (prefix.isEmpty() && !reversedSuffix.isEmpty()) {
            T elem;
            while ((elem = reversedSuffix.poll()) != null) {
                prefix.push(elem);
            }
        }
        return prefix.isEmpty() ? null : prefix.pop();
    }
}

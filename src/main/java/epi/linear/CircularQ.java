package epi.linear;

import java.util.*;

public class CircularQ<T> {
    private int head, tail;
    private T[] data = null;

    public CircularQ(int initialCap) {
        resize(initialCap);
        dump();
    }

    public void offer(T datum) {
        add(datum);
        System.out.println(">> offer :: " + datum);
        dump();
        if (head == tail) {
            resize(2 * data.length);
        }
        dump();
        System.out.println("<<");
    }

    public T poll() {
        if (head == -1) {
            return null;
        } else {
            T datum = data[head];
            head = inc(head);
            if (head == tail) {
                resetPointers();
            }
            dump();
            return datum;
        }
    }

    public T peek() {
        return (head == -1) ? null : data[head];
    }

    public String toString() {
        var sb = new StringBuilder();
        for (int i = head; i != tail; i = inc(i)) {
            sb.append(data[i].toString());
        }
        return sb.toString();
    }

    private void add(T datum) {
        data[tail] = datum;
        if (head == -1) {
            head = tail;
        }
        tail = (tail + 1) % data.length;
    }

    private void dump() {
        var topSb = new StringBuilder();
        var bottomSb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            topSb.append(Optional.ofNullable(data[i]).map(Object::toString).orElse("_"));
            if (i == head) {
                bottomSb.append((i == tail) ? 'X' : 'H');
            } else if (i == tail) {
                bottomSb.append('T');
            } else {
                bottomSb.append(' ');
            }
        }
        System.out.println(topSb.toString());
        System.out.println(bottomSb.toString());
    }

    @SuppressWarnings("unchecked")
    private void resize(int cap) {
        T[] newData = (T[])new Object[cap];
        int numCopied = 0;
        if (data != null && head != -1) {
            int j = 0;
            for (int i = head; i < data.length; i++) {
                newData[j++] = data[i];
            }
            for (int i = 0; i < head; i++) {
                newData[j++] = data[i];
            }
            numCopied = data.length;
        }
        data = newData;
        head = (numCopied > 0) ? 0 : -1;
        tail = numCopied;
    }

    private void resetPointers() {
        head = -1;
        tail = 0;
    }

    private int inc(int i) {
        return (i + 1) % data.length;
    }
}

package epi.lists;

import java.util.List;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(Node<T> next) {
        this(null, next);
    }

    public Node(T value) {
        this(value, null);
    }

    public Node() {
        this(null, null);
    }

    public T value() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> next() {
        return next;
    }

    public void setNext(Node<T> node) {
        next = node;
    }

    @SafeVarargs
    public static <T> Node<T> listOf(T... values) {
        int n = values.length;
        var dummy = new Node<T>();
        var head = dummy;
        for (int i = n - 1; i >= 0; i--) {
            var node = new Node<T>(values[i]);
            node.setNext(head.next());
            head.setNext(node); 
        }
        return dummy.next();
    }

    public static <T> Node<T> cycleTerminatedListOf(List<T> values, T cycleEntryValue) {
        if (values.isEmpty()) {
            return null;
        }

        int i, n;
        Node<T> p, cycleHead = null;
        Node<T> beforeHead = new Node<>();
        for (p = beforeHead, i = 0, n = values.size(); i < n; i++, p = p.next()) {
            var value = values.get(i);
            var nextNode = new Node(value);
            p.setNext(nextNode);
            if (cycleHead == null && cycleEntryValue.equals(value)) {
                cycleHead = nextNode;
            }
        }
        p.setNext(cycleHead);
        return beforeHead.next();
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", value, (next == null) ? "X" : "->");
    }

    public static <T> String toString(Node<T> head) {
        var sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(String.valueOf(head.value()));
            if (head.next() != null) {
                sb.append(", ");
            }
            head = head.next();
        }
        sb.append("]");
        return sb.toString();
    }
}

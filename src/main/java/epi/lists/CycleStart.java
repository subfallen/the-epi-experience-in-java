package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class CycleStart {
	public static <T extends Comparable> Optional<Node<T>> cycleStart(Node<T> head) {
		if (head == null || head.next() == null) {
			return Optional.empty();
		}
		
		Node<T> slowPtr = head.next(), fastPtr = head.next().next();
		while (fastPtr != null && (slowPtr != fastPtr)) {
			slowPtr = slowPtr.next();
			fastPtr = Optional.ofNullable(fastPtr.next()).map(Node::next).orElse(null);
		}
		if (fastPtr == null) {
			return Optional.empty();
		}

		slowPtr = head;
		while (slowPtr != fastPtr) {
			slowPtr = slowPtr.next();
			fastPtr = fastPtr.next();
		}
		return Optional.of(slowPtr);
	}
}

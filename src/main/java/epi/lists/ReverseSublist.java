package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class ReverseSublist {
	public static <T extends Comparable> Node<T> reverse(Node<T> head, int first, int inclusiveLast) {
		Node<T> headPtr = new Node<T>(head); 
		Node<T> beforeFirst = null, last = null;

		Node<T> prev = headPtr, next = headPtr.next();
		for (int i = 1; next != null; i++, prev = next, next = next.next()) {
			if (i == first) {
				beforeFirst = prev;
			} 
			if (i == inclusiveLast) {
				last = next;
				break;
			} 
		}

		if (beforeFirst == null || last == null) {
			throw new IllegalArgumentException(String.format(
						"List rooted @ %s has no sublist [%d, %d]!",
						head,
						first,
						inclusiveLast));
		}

		Node<T> afterLast = last.next(), firstPtr = beforeFirst.next();
		last.setNext(null);
		reverse(beforeFirst.next());
		beforeFirst.setNext(last);
		firstPtr.setNext(afterLast);
			
		return headPtr.next();
	}

	private static <T extends Comparable> Node<T> reverse(Node<T> head) {
		if (head == null) {
			return head;
		}	

		Node<T> prev = null, cur = head;
		while (cur != null) {
			Node<T> tmp = cur.next();
			cur.setNext(prev);
			prev = cur;
			cur = tmp;
		}
		return prev;
	}
}

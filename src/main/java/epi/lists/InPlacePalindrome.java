package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class InPlacePalindrome {
	public static <T> boolean test(Node<T> head) {
		Node<T> secondHalf = splitHalfway(head);	
		System.out.println("Second half is: " + Node.toString(secondHalf));
		secondHalf = reversed(secondHalf);
		System.out.println("Second half reversed is: " + Node.toString(secondHalf));
		boolean isPalindrome = true;
		Node<T> p = head, q = secondHalf;
		Node<T> preP = new Node<>(p);
		while (q != null) {
			if (!p.value().equals(q.value())) {
				isPalindrome = false;
			}
			p = p.next();
			preP = preP.next();
			q = q.next();
		}
		if (p != null) {
			p.setNext(reversed(secondHalf));
		} else {
			preP.setNext(reversed(secondHalf));
		}
		return isPalindrome;
	}

	private static <T> Node<T> reversed(Node<T> head) {
		Node<T> cur = head, prev = null;	
		while (cur != null) {
			Node<T> next = cur.next();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		return prev;
	}

	private static <T> Node<T> splitHalfway(Node<T> head) {
		if (head.next() == null) {
			return head;
		}
		Node<T> slow = head, fast = head, preSlow = new Node<>(head);
		while (fast != null && fast.next() != null) {
			fast = fast.next().next();
			slow = slow.next();
			preSlow = preSlow.next();
		}
		if (fast != null) {
			slow = slow.next();
			preSlow = preSlow.next();
		}
		preSlow.setNext(null);
		return slow;
	}
}

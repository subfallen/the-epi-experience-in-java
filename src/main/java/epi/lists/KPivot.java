package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class KPivot {
	public static Node<Integer> of(Node<Integer> head, Integer k) {
		Node<Integer> preHeadSmall = new Node<>(),  
			preHeadEqual = new Node<>(), 
			preHeadLarge = new Node<>();
		Node<Integer> smallTail = preHeadSmall, equalTail = preHeadEqual, largeTail = preHeadLarge;
		Node<Integer> p = head;
		while (p != null) {
			Node<Integer> q = p.next();
			var v = p.value();
			if (v < k) {
				smallTail = appendTo(smallTail, p);
			} else if (v == k) {
				equalTail = appendTo(equalTail, p);
			} else {
				largeTail = appendTo(largeTail, p);
			}
			p = q;
		}
		if (equalTail != preHeadEqual) {
			smallTail.setNext(preHeadEqual.next());
			equalTail.setNext(preHeadLarge.next());
		} else {
			smallTail.setNext(preHeadLarge.next());
		}
		return preHeadSmall.next();
	}

	private static Node<Integer> appendTo(Node<Integer> tail, Node<Integer> next) {
		tail.setNext(next);
		tail = next;
		next.setNext(null);
		return tail;
	}
}

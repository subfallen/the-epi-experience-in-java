package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class EvenOddMerge {
	public static <T> Node<T> of(Node<T> head) {
		Node<T> evenTail = head;
		Node<T> preOddHead = new Node<>();
		Node<T> oddTail = preOddHead;
		Node<T> nextOdd = evenTail.next();

		while (nextOdd != null) {
			oddTail.setNext(nextOdd);
			oddTail = oddTail.next();

			if (nextOdd.next() != null) {
				evenTail.setNext(nextOdd.next());
				evenTail = evenTail.next();
				nextOdd = evenTail.next();
			} else {
				nextOdd = null;
			}
			oddTail.setNext(null);
		}
		evenTail.setNext(preOddHead.next());
		return head;
	}
}

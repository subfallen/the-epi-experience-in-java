package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class LlSum {
	public static Node<Integer> sum(Node<Integer> a, Node<Integer> b) {
		Node<Integer> sumPtr = new Node<>();		
		Node<Integer> tailPtr = sumPtr;
		var carry = 0;
		while (a != null || b != null) {
			var aVal = (a != null) ? a.value() : 0;
			var bVal = (b != null) ? b.value() : 0;
			var s = aVal + bVal + carry;
			var remainder = s % 10; 
			carry = s / 10;
			tailPtr = append(tailPtr, remainder);
			if (a != null) {
				a = a.next();
			}
			if (b != null) {
				b = b.next();
			}
		}
		if (carry > 0) {
			tailPtr = append(tailPtr, carry);
		}
		return sumPtr.next();
	}

	private static Node<Integer> append(Node<Integer> tail, Integer value) {
		tail.setNext(new Node<Integer>(value));
		return tail.next();
	}
}

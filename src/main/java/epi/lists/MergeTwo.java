package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;
import static java.nio.charset.StandardCharsets.*;

public class MergeTwo {
	public static <T extends Comparable> Node<T> merge(Node<T> p, Node<T> q) {
		Comparator<T> natural = Comparator.naturalOrder();
		var dummy = new Node<T>();
		var tail = dummy;
		while (p != null && q != null) {
			if (natural.compare(p.value(), q.value()) <= 0) {
				tail.setNext(p);						
				p = p.next();
			} else {
				tail.setNext(q);
				q = q.next();
			}
			tail = tail.next();
		}
		var rest = Optional.ofNullable(p).orElse(q);
		if (rest != null) {
			tail.setNext(rest);
		}
		return dummy.next();
	}
}

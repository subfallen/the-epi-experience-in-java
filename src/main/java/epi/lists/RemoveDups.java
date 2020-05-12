package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class RemoveDups {
	public static <T> Node<T> from(Node<T> head) {
		var cur = head;
		while (cur != null) {
			var next = cur.next();
			while (next != null && next.value().equals(cur.value())) {
				next = next.next();
			}
			cur.setNext(next);
			cur = next;
		}
		return head;
	}
}

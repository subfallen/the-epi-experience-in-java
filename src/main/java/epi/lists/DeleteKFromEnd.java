package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class DeleteKFromEnd {
	/* k = 0 means delete the last node */
	public static <T> Node<T> given(Node<T> head, int k) {
		var dummy = new Node<T>(head);
		var beforeTarget = dummy;
		var p = head;
		for (int i = 0; i <= k; i++) {
			p = p.next();
		}
		while (p != null) {
			beforeTarget = beforeTarget.next();
			p = p.next();
		}
		beforeTarget.setNext(beforeTarget.next().next());
		return dummy.next();
	}
}

package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class CylicRightShift {
	public static <T> Node<T> appliedTo(Node<T> head, int k) {
		Node<T> tailP = head;
		for (int i = 0; i < k; i++) {
			tailP = tailP.next();
		}
		Node<T> newTailP = head;
		while (tailP.next() != null) {
			tailP = tailP.next();
			newTailP = newTailP.next();
		}
		var newHead = newTailP.next();
		tailP.setNext(head);
		newTailP.setNext(null);
		return newHead;
	}
}

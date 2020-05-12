package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class FirstSharedWithCycles {
	public static <T extends Comparable> Node<T> intersection(Node<T> p, Node<T> q) {
		Optional<Node<T>> pCycle = cycleStart(p), qCycle = cycleStart(q);
		if (pCycle.isPresent() != qCycle.isPresent()) {
			return null;
		}
		if (pCycle.isPresent()) {
			if (qCycle.get() != pCycle.get()) {
				return rootIfReachable(qCycle.get(), pCycle.get());
			} else {
				var nullSub = pCycle.get();
				int pLen = lenTo(p, nullSub);
				int qLen = lenTo(q, nullSub);
				var longWalk = (pLen > qLen) ? p : q;
				var shortWalk = (pLen > qLen) ? q : p;
				for (int i = 0, n = Math.abs(pLen - qLen); i < n; i++) {
					longWalk = longWalk.next();
				}
				while (longWalk != shortWalk) {
					longWalk = longWalk.next();
					shortWalk = shortWalk.next();
				}
				return shortWalk;
			}
		} else {
			return FirstShared.intersection(p, q);
		}
	}

	private static <T> int lenTo(Node<T> root, Node<T> nullSub) {
		int len = 0;
		while (root != nullSub) {
			root = root.next();
			len++;
		}
		return len;
	}

	private static <T> Node<T> rootIfReachable(Node<T> cycleRoot, Node<T> from) {
		var p = from.next();
		while (p != from && p != cycleRoot) {
			p = p.next();
		}
		return (p == cycleRoot) ? cycleRoot : null;
	}

	private static <T> Optional<Node<T>> cycleStart(Node<T> root) {
		if (root == null || root.next() == null) {
			return Optional.empty();
		}
		Node<T> slow = root.next(), fast = root.next().next();
		while (fast != null && slow != fast) {
			slow = slow.next();
			fast = fast.next();
			if (fast != null) {
				fast = fast.next();
			}
		}
		if (fast == null) {
			return Optional.empty();
		}
		slow = root;
		while (slow != fast) {
			slow = slow.next();
			fast = fast.next();
		}
		return Optional.of(slow);
	}
}

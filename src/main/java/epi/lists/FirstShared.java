package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class FirstShared {
	public static <T extends Comparable> Node<T> intersection(Node<T> p, Node<T> q) {
		int pLen = len(p), qLen = len(q);

		var lp = (pLen > qLen) ? p : q;
		var sp = (pLen > qLen) ? q : p;

		for (int i = 0, n = Math.abs(pLen - qLen); i < n; i++) {
			lp = lp.next();
		}

		while (sp != lp) {
			sp = sp.next();
			lp = lp.next();
		}

		return sp;
	}

	private static int len(Node<?> r) {
		int l = 0;
		while (r != null) {
			r = r.next();
			l++;
		}
		return l;
	}
}

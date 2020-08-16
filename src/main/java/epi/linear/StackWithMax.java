package epi.linear;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class StackWithMax<T extends Comparable<T>> {
	private final Deque<T> maxes = new ArrayDeque<>();
	private final Deque<T> values = new ArrayDeque<>();

	public T max() {
		return maxes.peek();	
	}

	public T pop() {
		var off = values.pop();		
		if (maxes.peek().equals(off)) {
			maxes.pop();
		}
		return off;
	}

	public void push(T value) {
		if (maxes.isEmpty() || maxes.peek().compareTo(value) <= 0) {
			maxes.push(value);
		}
		values.push(value);
	}
}

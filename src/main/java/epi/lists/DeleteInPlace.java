package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class DeleteInPlace {
	public static <T> void atInternal(Node<T> p) {
		if (p == null || p.next() == null) {
			throw new IllegalArgumentException();
		}
		p.setValue(p.next().value());
		p.setNext(p.next().next());
	}
}

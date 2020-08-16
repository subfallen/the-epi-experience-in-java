package epi.linear;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.regex.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class RpnEval {
	enum OpType { 
		PLUS {
			@Override
			public BinaryOperator<Integer> action() {
				return (a, b) -> a + b;
			}
		}, MINUS {
			@Override
			public BinaryOperator<Integer> action() {
				return (a, b) -> a - b;
			}
		}, MULTIPLY {
			@Override
			public BinaryOperator<Integer> action() {
				return (a, b) -> a * b;
			}
		}, DIVIDE {
			@Override
			public BinaryOperator<Integer> action() {
				return (a, b) -> a / b;
			}
		}, NONE {
			@Override
			public BinaryOperator<Integer> action() {
				throw new UnsupportedOperationException();
			}
		};

		abstract BinaryOperator<Integer> action();
	}

	public static Integer valueOf(String expr) {
		String[] args = expr.split(",");
		if (args.length == 1) {
			return Integer.parseInt(args[0]);
		} else {
			Deque<Integer> stack = new ArrayDeque<>();
			for (int i = 0; i < args.length; i++) {
				var op = asOp(args[i]);
				if (op == OpType.NONE) {
					stack.push(Integer.parseInt(args[i]));
				} else {
					var arg2 = stack.pop(); 
					var arg1 = stack.pop();
					stack.push(op.action().apply(arg1, arg2));
				}
			}
			return stack.peek();
		}
	}

	private static OpType asOp(String s) {
		if (s.length() != 1) {
			return OpType.NONE;
		} else {
			return OPS.getOrDefault(s, OpType.NONE);
		}
	}

	private static Map<String, OpType> OPS = Map.of(
				"+", OpType.PLUS,
				"-", OpType.MINUS,
				"*", OpType.MULTIPLY,
				"/", OpType.DIVIDE
			);
}

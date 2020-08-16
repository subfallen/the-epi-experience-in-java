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

public class WellBracketed {
    private static String LEFT = "[({";
    private static String RIGHT = "])}";

    public static boolean isValid(String expr) {
        var left = new ArrayDeque<Character>();
        for (char c : expr.toCharArray()) {
            var lI = LEFT.indexOf(c);
            if (lI == -1) {
                if (left.isEmpty()) {
                    return false;
                }
                var rI = RIGHT.indexOf(c);
                var expected = LEFT.charAt(rI);
                var actual = left.pop();
                if (!actual.equals(expected)) {
                    return false;
                } 
            } else {
                left.push(LEFT.charAt(lI));
            }
        }
        return left.isEmpty();
    }
}

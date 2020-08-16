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

public class ShortestPathname {
    public static String normalized(String path) {
	var parts = path.split("/");
	var normalizedParts = new ArrayDeque<String>();
	for (String part : parts) {
            if (part.length() == 0 || ".".equals(part)) {
                continue;
            }
            if ("..".equals(part)) {
                if (normalizedParts.isEmpty() || "..".equals(normalizedParts.peek())) {
                    normalizedParts.push(".."); 
                } else {
                    normalizedParts.pop();
                }
            } else {
                normalizedParts.push(part);
            }
	}
        var sb = new StringBuilder();
        if (path.startsWith("/")) {
            sb.append("/");
        }
        var iter = normalizedParts.descendingIterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext()) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}

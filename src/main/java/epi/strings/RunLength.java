package epi.strings;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class RunLength {
    public static String rlEncode(String s) {
        var sb = new StringBuilder();
        for (int i = 0, n = s.length(); i < n; ) {
            char cur = s.charAt(i);
            int j = i;
            while ((j + 1 < n) && s.charAt(j + 1) == cur) {
                j++;
            }
            sb.append(j - i + 1).append(cur);
            i = j + 1;
        }
        return sb.toString();
    }
    
    public static String rlDecode(String s) {
        var sb = new StringBuilder();
        for (int i = 0, n = s.length(); i < n; ) {
            int j = i;
            while (Character.isDigit(s.charAt(j + 1))) {
                j++;
            }
            char cur = s.charAt(j + 1);
            for (int k = 0, m = Integer.parseInt(s.substring(i, j + 1)); k < m; k++) {
                sb.append(cur);
            }
            i = j + 2;
        }
        return sb.toString();
    }
}

package epi.strings;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;

public class LookAndSayN {
    public static String lookAndSay(int n) {
        String it = "1";
        while (n > 1) {
            it = describe(it);
            n--;
        }
        return it;
    }

    private static String describe(String digits) {
        var sb = new StringBuilder();
        int count = 1;
        char d = digits.charAt(0);
        for (int i = 1, n = digits.length(); i < n; i++) {
            char e = digits.charAt(i);
            if (e == d) {
                count++;
            } else {
                sb.append(Integer.toString(count)).append(d);
                count = 1;
                d = e;
            }
        }
        sb.append(Integer.toString(count)).append(d);
        return sb.toString();
    }
}

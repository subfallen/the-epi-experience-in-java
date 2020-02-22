package epi.strings;

import java.util.*;

public class IsPalindrome {
    public static boolean test(String s) {
        for (int l = 0, r = s.length() - 1; l <= r; l++, r--) {
            l = nextTestable(s, l);
            r = prevTestable(s, r);
            if (l <= r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int nextTestable(String s, int i) {
        for (int n = s.length(); i < n; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                return i;
            }
        }
        return s.length();
    }

    private static int prevTestable(String s, int i) {
        while (i >= 0) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                return i;
            }
            i--;
        }
        return -1;
    }
}

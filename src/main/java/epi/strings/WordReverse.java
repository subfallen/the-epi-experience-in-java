package epi.strings;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;

public class WordReverse {
    public static String reverseWords(String s) {
        var words = Stream.of(s.split("\\s+")).collect(toList());
        Collections.reverse(words);
        return words.stream().collect(joining(" "));
    }

    public static String reverseWordsByHand(String s) {
        char[] a = s.toCharArray();
        reverse(a, 0, a.length);
        int wordStart = -1;
        for (int i = 0; i < a.length; i++) {
            if (isLetter(a[i])) {
                if (wordStart == -1) {
                    wordStart = i;
                }
            } else {
                if (wordStart != -1) {
                    reverse(a, wordStart, i);
                    wordStart = -1;
                }
            }
        }
        if (wordStart != -1) {
            reverse(a, wordStart, a.length);
        }
        return new String(a);
    }

    private static void reverse(char[] a, int start, int end) {
        /* Number of elements in the prefix up to and including the lower median. */
        int n = (end - start + 1) / 2;
        for (int i = 0; i < n; i++) {
            char tmp = a[start + i];
            a[start + i] = a[end - 1 - i];
            a[end - 1 - i] = tmp;
        }
    }
}

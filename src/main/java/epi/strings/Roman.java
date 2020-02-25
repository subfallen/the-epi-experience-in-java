package epi.strings;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;

public class Roman {
    private static char[] NUMERALS = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private static int[] VALUES = {1, 5, 10, 50, 100, 500, 1000};
    private static int asInt(char numeral) {
        for (int i = 0; i < NUMERALS.length; i++) {
            if (numeral == NUMERALS[i]) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }
    private static int valueOfRoman(char numeral) {
        return VALUES[asInt(numeral)];
    }

    public static int convert(String roman) {
        int v = 0;
        int ex = 0;
        char[] numerals = roman.toCharArray();
        boolean isException;
        for (int i = 0; i < numerals.length; i++) {
            int cur = asInt(numerals[i]);
            isException = false;
            if (i < numerals.length - 1) {
                int delta = asInt(numerals[i + 1]) - cur;
                if (delta > 0 && delta <= 2) {
                    isException = true;
                }
            }
            if (isException) {
                ex = -1 * VALUES[cur];
            } else {
                v += (VALUES[cur] + ex);
                ex = 0;
            }
        }
        return v;
    }
}

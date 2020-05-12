package epi.strings;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;
import static java.nio.charset.StandardCharsets.*;
import static java.lang.Math.floorMod;

public class RabinKarp {
    private static int BASE = 'Z' - 'A' + 1;
    private static int MODULUS = 997;

    public static int search(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) {
            return 0;
        }
        if (m > n) {
            return -1;
        }

        int sHash = 0, tHash = 0;
        int highOrderPower = 0;
        for (int i = 0; i < m; i++) {
            highOrderPower = (i > 0) ? (highOrderPower * BASE % MODULUS) : 1;
            int nextS = asInt(s.charAt(i)), nextT = asInt(t.charAt(i));
            sHash = floorMod(sHash * BASE + nextS, MODULUS);
            tHash = floorMod(tHash * BASE + nextT, MODULUS);
        }

        for (int i = m; i < n; i++) {
            if (sHash == tHash && s.equals(t.substring(i - m, i))) {
                return i - m;
            }
            int oldT = asInt(t.charAt(i - m)), newT = asInt(t.charAt(i));
            tHash = floorMod(tHash - oldT * highOrderPower, MODULUS);
            tHash = floorMod(tHash * BASE + newT, MODULUS);
        }

        if (sHash == tHash && s.equals(t.substring(n - m, n))) {
            return n - m;
        }

        return -1;
    }

    private static int asInt(char c) {
        return (int)(c - 'A');
    }
}

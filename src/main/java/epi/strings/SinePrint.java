package epi.strings;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class SinePrint {
    static final int[] ROWS = { 1, 0, -1 };
    static final int[] ROW_CYCLE = {0, 1, 0, -1};
    public static String waveForm(String s) {
        StringBuilder sb = new StringBuilder();
        for (int row : ROWS) {
            for (int i = 0, n = s.length(); i < n; i++) {
                if (row == ROW_CYCLE[i % 4]) {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}

package epi.strings;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;

public class AllIps {
    public static List<String> enumerated(String digits) {
        var all = new ArrayList<String>();

        int N = digits.length();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1, n = min(i + 4, N - 2); j < n; j++) {
                for (int k = j + 1, m = min(j + 4, N - 1); k < m; k++) {
                    int[] parts = new int[] {
                            Integer.parseInt(digits.substring(0, i + 1)),
                            Integer.parseInt(digits.substring(i + 1, j + 1)),
                            Integer.parseInt(digits.substring(j + 1, k + 1)),
                            Integer.parseInt(digits.substring(k + 1, N))
                    };
                    if (isValid(parts)) {
                        all.add(
                                Arrays.stream(parts)
                                    .mapToObj(Integer::toString)
                                    .collect(joining(".")));
                    }
                }
            }
        }

        return all;
    }

    private static boolean isValid(int[] digits) {
        return digits[0] > 0 && Arrays.stream(digits).allMatch(i -> 0 <= i && i <= 255);
    }
}

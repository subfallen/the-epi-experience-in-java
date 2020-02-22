package epi.strings;

import java.util.*;

public class ReplaceAndRemove {
    public static void process(char[] a, int n) {
        int rec = 0, numAs = 0;
        for (int obs = 0; obs < a.length; obs++) {
            if (a[obs] != 'b') {
                a[rec++] = a[obs];
                if (a[obs] == 'a') {
                    numAs++;
                }
            }
        }

        int start = rec - 1;
        rec = start + numAs;
        for (int obs = start; obs >= 0; obs--) {
            if (a[obs] != 'a') {
                a[rec--] = a[obs];
            } else {
                a[rec--] = 'd';
                a[rec--] = 'd';
            }
        }
    }
}

package epi.arrays;

import java.util.*;
import static java.util.Arrays.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class NextPerm {
  public static final int[] EMPTY_PERM = {};

  public static int[] from(int[] p) {
    int n = p.length;
    int i = n - 1;
    while (i > 0 && (p[i] < p[i - 1])) {
      i--;
    }

    if (i > 0) {
      int j = n - 1;
      while (p[j] < p[i - 1]) {
        j--;
      }
      swap(p, i - 1, j);
      for (int k = 0; (i + k) < (n - 1 - k); k++) {
        swap(p, i + k, n - 1 - k);
      }
      return p;
    } else {
      return EMPTY_PERM;
    }
  }

  private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}

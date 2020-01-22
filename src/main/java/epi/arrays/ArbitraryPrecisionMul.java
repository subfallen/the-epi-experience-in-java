package epi.arrays;

import java.util.List;
import java.util.LinkedList;
import static java.util.Collections.swap;

public class ArbitraryPrecisionMul {
  public static List<Integer> mul(List<Integer> a, List<Integer> b) {
    boolean isNegative = a.get(0) * b.get(0) < 0;
    a.set(0, Math.abs(a.get(0)));
    b.set(0, Math.abs(b.get(0)));

    List<Integer> c = new LinkedList<>();
    c.add(0);
    if (a.stream().allMatch(i -> i == 0) || b.stream().allMatch(i -> i == 0)) {
      return c;
    }

    int M = a.size(), N = b.size();
    for (int i = N - 1, leadingZeros = 0; i >= 0; i--, leadingZeros++) {
      List<Integer> partial = new LinkedList<>(a);
      for (int j = 0; j < leadingZeros; j++) {
        partial.add(0);
      }
      scaleBy(partial, b.get(i));
      addTo(c, partial);  
    }
    
    if (isNegative) {
      c.set(0,  -1 * c.get(0));
    }

    return c;
  }

  private static void scaleBy(List<Integer> l, int c) {
    int carry = 0;
    int n = l.size();
    for (int i = n - 1; i >= 0; i--) {
      int outcome = c * l.get(i) + carry;
      l.set(i, outcome % 10);
      carry = outcome / 10;
    }
    if (carry > 0) {
      l.add(0, carry);
    }
  }

  private static void addTo(List<Integer> a, List<Integer> b) {
    while (a.size() < b.size()) {
      a.add(0, 0);
    }
    int carry = 0;
    int n = a.size();
    for (int i = n - 1; i >= 0; i--) {
      int sum = a.get(i) + b.get(i) + carry;
      a.set(i, sum % 10);
      carry = sum / 10;
    }
    if (carry > 0) {
      a.add(0, carry);
    }
  }
}

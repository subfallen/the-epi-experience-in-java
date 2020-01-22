package epi.arrays;

import java.util.List;
import java.util.LinkedList;
import static java.util.Collections.swap;

public class ArbitraryPrecisionInc {
  public static List<Integer> inc(List<Integer> l) {
    int n = l.size(), plus = 1, carry = 0;
    List<Integer> lPlusOne = new LinkedList<>();
    for (int i = n - 1; i >= 0; i--) {
      int start = l.get(i).intValue();
      int sum = carry + plus + start;
      carry = sum / 10;
      lPlusOne.add(0, sum % 10);
      plus = 0;
    }
    if (carry > 0) {
      lPlusOne.add(0, carry);
    }
    return lPlusOne;
  }
}

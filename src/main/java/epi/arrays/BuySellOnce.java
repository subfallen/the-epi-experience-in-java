package epi.arrays;

import java.util.List;
import java.util.Collections;

public class BuySellOnce {
  public static int maxValue(List<Integer> l) {
    if (l.size() < 2) {
      return 0;
    }

    int maxProfit = 0;
    int bestEntry = 0;
    for (int i = 1; i < l.size(); i++) {
      maxProfit = Math.max(maxProfit, l.get(i) - l.get(bestEntry)); 
      if (l.get(i) < l.get(bestEntry)) {
        bestEntry = i;
      }
    }

    return maxProfit;
  }
}

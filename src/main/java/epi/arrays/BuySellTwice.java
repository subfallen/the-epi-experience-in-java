package epi.arrays;

import java.util.stream.IntStream;
import java.util.List;

public class BuySellTwice {
  public static int maxValue(List<Integer> l) {
    int n = l.size();
    if (n < 2) {
      return 0;
    }

    int[] maxPrefixValues = new int[n + 1];
    int[] maxSuffixValues = new int[n + 1];

    int minEntry = l.get(0);
    for (int i = 1; i < n; i++) {
      maxPrefixValues[i] = Math.max(maxPrefixValues[i - 1], l.get(i) - minEntry);
      minEntry = Math.min(minEntry, l.get(i));
    }

    int maxExit = l.get(n - 1);
    for (int i = n - 2; i >= 0; i--) {
      maxSuffixValues[i] = Math.max(maxSuffixValues[i + 1], maxExit - l.get(i));
      maxExit = Math.max(maxExit, l.get(i));
    }

    return IntStream.range(0, n).map(i -> maxPrefixValues[i] + maxSuffixValues[i + 1]).max().getAsInt();
  }
}

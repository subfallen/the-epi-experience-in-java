package epi.arrays;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class InPlacePermute {
  public static void permute(List<Integer> a, List<Integer> p) {
    int n = a.size();
    for (int i = 0; i < n; i++) {
      if (p.get(i) >= 0) {
        permuteCycle(a, p, i);
      }
    }

    for (int i = 0; i < n; i++) {
      p.set(i, -1 * p.get(i) - 1);
    }
  }

  private static void permuteCycle(List<Integer> a, List<Integer> p, int start) {
    int valToSet = a.get(start);
    int indexToSet = p.get(start);
    do {
      int nextValToSet = a.get(indexToSet);
      a.set(indexToSet, valToSet);
      int nextIndexToSet = p.get(indexToSet);
      if (nextIndexToSet >= 0) {
        p.set(indexToSet, -1 * nextIndexToSet - 1);
      }
      indexToSet = nextIndexToSet;
      valToSet = nextValToSet;
    } while (indexToSet >= 0);
  }
}

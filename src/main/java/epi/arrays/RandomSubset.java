package epi.arrays;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class RandomSubset {
  public static List<Integer> given(int n, int k) {
    var r = ThreadLocalRandom.current();
    var all = sparseList(n);
    for (int i = 0; i < k; i++) {
      Collections.swap(all, i, i + r.nextInt(n - i));
    }
    return all.subList(0, k);
  }

  private static List<Integer> sparseList(int n) {
    return new AbstractList<>() {
      final Map<Integer, Integer> overrides = new HashMap<>();

      @Override
      public Integer get(int i) {
        return overrides.getOrDefault(i, i);  
      }

      @Override
      public Integer set(int i, Integer v) {
        Integer oldV = get(i);
        overrides.put(i, v);
        return oldV;
      }

      @Override
      public int size() {
        return n;
      }
    };
  }
}

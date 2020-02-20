package epi.arrays;

import java.math.BigDecimal;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class NonUniformSample {
  public static Supplier<Integer> from(Map<Integer, BigDecimal> P) {
    final var xs = P.keySet().stream().mapToInt(Integer::intValue).toArray();
    final var ps = new double[xs.length];
    for (int i = 0; i < ps.length; i++) {
      ps[i] = P.get(xs[i]).doubleValue() + (i > 0 ? ps[i - 1] : 0);
    }
    
    return () -> {
      var r = ThreadLocalRandom.current();
      var draw = r.nextDouble();
      var choice = Arrays.binarySearch(ps, draw);
      if (choice >= 0) {
        return xs[choice];
      } else {
        return xs[-choice - 1];
      }
    };
  }
}

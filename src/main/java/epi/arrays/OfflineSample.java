package epi.arrays;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class OfflineSample {

  public static void sample(List<Integer> a, int k) {
    var r = ThreadLocalRandom.current();
    for (int i = 0, n = a.size(); i < k; i++) {
      Collections.swap(a, i, i + r.nextInt(n - i));
    }
  }
}

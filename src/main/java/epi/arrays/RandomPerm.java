package epi.arrays;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class RandomPerm {
  public static List<Integer> upTo(int n) {
    var p = new ArrayList<Integer>(n);
    for (int i = 0; i < n; i++) {
      p.add(i);
    }
    OfflineSample.sample(p, n);
    return p;
  }
}

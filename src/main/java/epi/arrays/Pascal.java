package epi.arrays;

import java.math.BigDecimal;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class Pascal {
  public static List<List<Integer>> upToRow(int n) {
    List<List<Integer>> rows = new ArrayList<>();
    rows.add(List.of(1));
    rows.add(List.of(1, 1));
    for (int i = 3; i <= n; i++) {
      List<Integer> prev = rows.get(i - 2);
      List<Integer> row = new ArrayList<>(i);
      row.add(1);
      for (int j = 0; j < i - 2; j++) {
        row.add(prev.get(j) + prev.get(j + 1));
      }
      row.add(1);
      rows.add(row);
    }
    return rows.subList(0, n);
  }
}

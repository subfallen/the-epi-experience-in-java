package epi.arrays;

import java.math.BigDecimal;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class SpiralOrder {
  public static int[] spiral(int[][] b) {
    var l = new ArrayList<Integer>();
    int n = b.length;
    for (int start = 0, steps = n - 1; steps >= 0; start++, steps -= 2) {
      addSingle(b, start, steps, l);
    }
    return l.stream().mapToInt(Integer::intValue).toArray();
  }

  private static void addSingle(int[][] b, int start, int steps, List<Integer> l) {
    int row = start, col = start;
    l.add(b[row][col]);
    for (Step step : Step.values()) {
      int n = steps - (step == Step.UP ? 1 : 0);     
      for (int i = 0; i < n; i++) {
        row += step.rowDelta();
        col += step.colDelta();
        l.add(b[row][col]);
      }
    }
  }

  private enum Step {
    RIGHT(0, 1), DOWN(1, 0), LEFT(0, -1), UP(-1, 0);

    private int rowDelta, colDelta;

    private Step(int rowDelta, int colDelta) {
      this.rowDelta = rowDelta;
      this.colDelta = colDelta;
    }

    public int rowDelta() {
      return rowDelta;
    }

    public int colDelta() {
      return colDelta;
    }
  }

}

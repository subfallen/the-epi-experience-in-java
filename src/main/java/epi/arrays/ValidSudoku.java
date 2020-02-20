package epi.arrays;

import java.math.BigDecimal;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class ValidSudoku {
  public static boolean hasDuplicate(int[][] b, int cellDim) {
    int n = cellDim * cellDim;
    for (int i = 0; i < n; i++) {
      if (duplicates(b[i])) {
        return true;
      }
      final int col = i;
      if (duplicates(IntStream.range(0, n).map(j -> b[j][col]).toArray())) {
        return true;
      }
      int cellRow = i / cellDim;
      int cellCol = i % cellDim;
      boolean cellDuplicate = duplicates(
          IntStream.range(cellRow * cellDim, (cellRow + 1) * cellDim)
              .mapToObj(row -> {
                var rowA = Arrays.copyOfRange(b[row], cellCol * cellDim, (cellCol + 1) * cellDim);
                System.out.println(
                    "(" + cellRow + ", " + cellCol + ") @ row " + row 
                        + " ==> " + Arrays.toString(rowA));
                return rowA;
              })
              .toArray(m -> new int[m][]));

      if (cellDuplicate) {
        return true;
      }
    }
    return false;
  }

  private static boolean duplicates(int[]... as) {
    int[][] args = as;
    System.out.println(Arrays.deepToString(args));
    var seen = new HashSet<Integer>();
    for (int[] a : as) {
      for (int v : a) {
        if (v > 0) {
          if (seen.contains(v)) {
            return true;
          }
          seen.add(v);
        }
      }
    }
    return false;
  }
}

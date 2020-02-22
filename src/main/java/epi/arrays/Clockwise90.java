package epi.arrays;

import java.math.BigDecimal;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class Clockwise90 {
  public static void rotate90(int[][] a) {
    for (int row = 0; row < a.length / 2; row++) {
      int n = a.length - row * 2;
      for (int col = 0; col < n - 1; col++) {
        cyclicRotation(a, row, row + col);
      }
    }
  }

  private static void cyclicRotation(int[][] a, int row, int col) {
    int n = a.length;
    int overwritten = a[row][col];
    for (int i = 0; i < 4; i++) {
      int xOffset = asOffset(col, n);
      int yOffset = -asOffset(row, n);

      int newRow = n - 1 - asIndex(-xOffset, n);
      int newCol = asIndex(yOffset, n);
      int newOverwritten = a[newRow][newCol];

      a[newRow][newCol] = overwritten;

      overwritten = newOverwritten;
      row = newRow;
      col = newCol;
    }
  }

  private static int asIndex(int offset, int n) {
    if (n % 2 == 0) {
      int leftZeroOffset = n / 2;
      if (offset > 0) {
        offset--;
      }
      return (offset + leftZeroOffset);
    } else {
      int zeroOffset = (n - 1) / 2;
      return (offset + zeroOffset);
    }
  }

  private static int asOffset(int i, int n) {
    if (n % 2 == 0) {
      int leftZeroOffset = n / 2;
      return (i - leftZeroOffset) + (i >= leftZeroOffset ? 1 : 0);
    } else {
      int zeroOffset = (n - 1) / 2;
      return (i - zeroOffset);
    }
  }
}

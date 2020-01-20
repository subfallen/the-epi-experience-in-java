package epi.primitives;

public class BitSwap {
  public static long swapBits(int i, int j, long n) {
    long mask = (1L << i) | (1L << j);
    long under = n & mask;
    return (under == mask || under == 0) ? n : (n ^ mask);
  }
}

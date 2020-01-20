package epi.primitives;

public class NearestOfEqualWeight {
  private static final long TEST_MASK = 0x03l;

  public static long given(long x) {
    if ((x & (x + 1)) == 0) {
      return (x + 1) / 2 + x;
    } else {
      long testMask = TEST_MASK;
      long firstYes = 1, secondYes = 2;
      for (int i = 0; i < 61; i++) {
        long underMask = x & testMask;
        if (underMask == firstYes || underMask == secondYes) {
          return x ^ testMask;
        }
        testMask <<= 1;
        firstYes <<= 1;
        secondYes <<= 1;
      }
      throw new IllegalArgumentException(String.format("%d is not a legal argument!", Long.MAX_VALUE));
    }
  }
}

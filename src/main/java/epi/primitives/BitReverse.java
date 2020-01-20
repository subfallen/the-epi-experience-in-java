package epi.primitives;

public class BitReverse {
  public static long reverseBits(long n) {
    long revN = 0;
    revN |= SHORT_REVERSE_LOOKUP[(int)((n >>> 48) & SHORT_MASK)];
    revN |= SHORT_REVERSE_LOOKUP[(int)((n >>> 32) & SHORT_MASK)] << 16;
    revN |= SHORT_REVERSE_LOOKUP[(int)((n >>> 16) & SHORT_MASK)] << 32;
    revN |= SHORT_REVERSE_LOOKUP[(int)(n & SHORT_MASK)] << 48;
    return revN;
  }

  private static long SHORT_MASK = 0xFFFFl;
  private static long[] SHORT_REVERSE_LOOKUP = new long[1 << 16];

  static {
    for (int i = 0; i < (1 << 16); i++) {
      SHORT_REVERSE_LOOKUP[i] = reverseIteratively((short)i) & SHORT_MASK;
    }
  }

  private static short reverseIteratively(short n) {
    short revN = 0;
    for (int i = 0; i < 16; i++) {
      revN = (short)((revN << 1) + (n & 1));
      n >>>= 1;
    }
    return revN;
  }
}

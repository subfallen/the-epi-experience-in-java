package epi.primitives;

public class LongParity {
  private static int PARITY_CACHE_MASK_LEN_BITS = 16;
  private static long PARITY_CACHE_MASK = (1 << PARITY_CACHE_MASK_LEN_BITS) - 1;
  private static int[] PARITY_CACHE = new int[(int)PARITY_CACHE_MASK + 1];
  private static int PARITY_CACHE_SIZE = PARITY_CACHE.length;
  static {
    for (int i = 0; i < PARITY_CACHE_SIZE; i++) {
      int parity = 0;
      int v = i;
      while (v > 0) {
        v &= (v - 1);
        parity ^= 1;
      }
      PARITY_CACHE[i] = parity;
    }
  }

  public static int compute(long v) {
    int parity = 0;
    for (int i = 0; i < 64 / PARITY_CACHE_MASK_LEN_BITS; i++) {
      int shift_len = (i * PARITY_CACHE_MASK_LEN_BITS);
      parity ^= PARITY_CACHE[(int)((v & (PARITY_CACHE_MASK << shift_len)) >>> shift_len)]; 
    }
    return parity;
  }
}

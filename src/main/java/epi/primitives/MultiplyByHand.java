package epi.primitives;

public class MultiplyByHand {
  public static long given(long x, long y) {
    long product = 0;
    while (y != 0) {
      if ((y & 1) == 1) {
        product = add(product, x);
      }
      x <<= 1;
      y >>>= 1;
    }
    return product;
  }

  private static long add(long aIn, long bIn) {
    long c = 0;
    long setter = 1;
    long overflow = 0;
    while ((aIn != 0) || (bIn != 0)) {
      long a = (aIn & 1);
      long b = (bIn & 1);

      if ((a | b | overflow) != 0) {
        if ((a & b) == 1 || (a & overflow) == 1 || (b & overflow) == 1) {
          if ((a & b & overflow) == 1) {
            c |= setter;
          }  
          overflow = 1;
        } else {
          overflow = 0;
          c |= setter;
        }
      }

      setter <<= 1; 
      aIn >>>= 1;
      bIn >>>= 1;
    }
    if (overflow == 1) {
      c |= setter;
    }

    return c;
  }
}

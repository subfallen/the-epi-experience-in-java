package epi.primitives;

public class DivideByHand {
  public static long given(long dividend, long divisor) {
    long quotient = 0;
    long pow = 1;

    while (true) {
      long candTerm = (divisor << 1);
      if (candTerm > 0 && candTerm <= dividend) {
        divisor = candTerm;
        pow <<= 1;
      } else {
        break;
      }
    }

    while (pow > 0) {
      if (dividend >= divisor) {
        quotient |= pow;
        dividend -= divisor;
      }
      divisor >>= 1;
      pow >>= 1;
    }

    return quotient;
  }
}

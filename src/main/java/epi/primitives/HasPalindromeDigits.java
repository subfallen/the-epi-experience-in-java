package epi.primitives;

public class HasPalindromeDigits {
  private static final int MAX_DIGITS;
  private static final long MAX_DIGIT_DIVISOR;
  static {
    long x = Long.MAX_VALUE;
    int numDigits = 0;
    while (x > 0) {
      numDigits++;
      x /= 10;
    }

    long divisor = 1;
    for (int i = 0; i < numDigits - 1; i++) {
      divisor *= 10;
    }

    MAX_DIGITS = numDigits;
    MAX_DIGIT_DIVISOR = divisor;
  }

  public static boolean given(long x) {
    if (x < 0) {
      return false;
    } else if (x == 0) {
      return true;
    } else {
      long divisor = MAX_DIGIT_DIVISOR;
      int numDigits = MAX_DIGITS;
      while (x < divisor) {
        numDigits--;
        divisor /= 10;
      }

      long xCopy = x;
      for (int i = 0; i < numDigits / 2; i++) {
        long msd = (x / divisor) % 10;
        long lsd = xCopy % 10;
        if (msd != lsd) {
          return false;
        }
        xCopy /= 10;
        divisor /= 10;
      }
      return true;
    }
  }
}

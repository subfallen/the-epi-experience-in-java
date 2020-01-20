package epi.primitives;

public class ReverseDigits {
  public static long given(long x) {
    boolean hasMinus = (x < 0);
    x = Math.abs(x);

    long answer = 0;
    while (x > 0) {
      long digit = x % 10;
      answer = (answer * 10) + digit;
      x /= 10;
    }

    return (hasMinus ? -1 : 1) * answer;
  }
}

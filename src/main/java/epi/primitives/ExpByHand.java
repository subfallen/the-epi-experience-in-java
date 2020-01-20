package epi.primitives;

public class ExpByHand {
  public static double given(double base, int pow) {
    double answer = 1.0;
    if (pow < 0) {
      base = 1.0 / base;
      pow *= -1;
    }
    while (pow > 0) {
      if ((pow & 1) == 1) {
        answer *= base;
      }
      base *= base;
      pow >>>= 1;
    }
    return answer;
  }
}

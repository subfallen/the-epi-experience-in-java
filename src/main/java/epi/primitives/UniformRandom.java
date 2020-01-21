package epi.primitives;

import java.util.function.BooleanSupplier;

public class UniformRandom {
  private final BooleanSupplier randomBit;

  public UniformRandom(BooleanSupplier randomBit) {
    this.randomBit = randomBit;
  }

  public int nextBetween(int a, int b) {
    int n = (b - a);
    int bitsToGen = (int)Math.floor(log2(n)) + 1;
    int generated = 0;
    do {
      generated = 0;
      for (int i = 0; i < bitsToGen; i++) {
        int nextBit = randomBit.getAsBoolean() ? 1 : 0;
        generated = (generated << 1) | nextBit;
      }
    } while (generated > n);
    return generated + a;
  }

  private double log2(int n) {
    return Math.log(n) / Math.log(2.0);
  }
}

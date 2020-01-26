package epi.arrays;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Primes {
  public static List<Integer> upTo(int n) {
    List<Integer> primes = new ArrayList<>();
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (isPrime[i]) {
        for (int j = 2; j <= n / i; j++) {
          isPrime[i * j] = false;
        }
      } 
    }
    return IntStream.rangeClosed(2, n).filter(i -> isPrime[i]).boxed().collect(toList()); 
  }
}

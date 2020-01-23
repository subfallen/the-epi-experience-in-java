package epi.arrays;

import java.util.List;

public class CanAdvance {
  public static boolean can(List<Integer> maxAdvance) {
    if (maxAdvance.isEmpty()) {
      return true;
    }
    int goal = maxAdvance.size() - 1;
    int reachable = maxAdvance.get(0);
    for (int i = 1; reachable < goal && i <= reachable; i++) {
      reachable = Math.max(reachable, i + maxAdvance.get(i)); 
    }
    return reachable >= goal;
  }
}

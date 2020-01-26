package epi.arrays;

import java.util.List;
import java.util.Collections;

public class DeDupSorted {
  public static int dedup(List<Integer> l, boolean shouldEchoRepeated) {
    if (l.isEmpty()) {
      return 0;
    }

    boolean includeDup = shouldEchoRepeated;
    int i = 1, nextRetained = 1;        
    while (i < l.size()) {
      if (l.get(i - 1) != l.get(i)) {
        l.set(nextRetained++, l.get(i));
        includeDup = shouldEchoRepeated;
      } else {
        if (includeDup) {
          l.set(nextRetained++, l.get(i));
          includeDup = false;
        }
      }
      i++;
    }
    return nextRetained;
  }

  public static int dedup(List<Integer> l) {
    if (l.isEmpty()) {
      return 0;
    }

    int i = 1, nextRetained = 1;        
    while (i < l.size()) {
      if (l.get(i - 1) != l.get(i)) {
        l.set(nextRetained++, l.get(i));
      }
      i++;
    }
    return nextRetained;
  }
}

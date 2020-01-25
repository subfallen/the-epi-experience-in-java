package epi.arrays;

import java.util.List;
import java.util.Collections;

public class DeleteKey {
  public static void del(List<Integer> l, Integer key) {
    int last = findNextUndeleted(l, l.size() - 1, key);
    int first = 0; 
    while (first < last) {
      if (l.get(first) == key) {
        Collections.swap(l, first, last);
        last = findNextUndeleted(l, last - 1, key);
      }
      first++;
    }
  }

  private static int findNextUndeleted(List<Integer> l, int from, int key) {
    while (from >= 0 && l.get(from) == key) {
      from--;
    }
    return from;
  }
}

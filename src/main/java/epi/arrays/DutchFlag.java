package epi.arrays;

import java.util.List;
import static java.util.Collections.swap;

public class DutchFlag {
  public enum Color { RED, WHITE, GREEN }

  public static void partition(List<Color> colors, int pivot) {
    /*
     * Given pivot colors[i] = C
     *
     * Use i, j, k :: invariants 
     *  [0, i) < C  
     *  [i, j] == C
     *  [i + 1, k) > C
     * */
    swap(colors, 0, pivot);        
    Color pivotColor = colors.get(0);
    int i = 0, j = 0, k;
    for (k = 1; k < colors.size(); k++) {
      Color c = colors.get(k);
      if (c.ordinal() <= pivotColor.ordinal()) {
        j++;
        swap(colors, j, k);
        if (c.ordinal() < pivotColor.ordinal()) {
          swap(colors, i, j);
          i++;
        }
      } 
    }
  }
}

package epi.arrays;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class OnlineSample {
  public static List<Integer> sample(DataInputStream dis, int k) {
    var a = new ArrayList<Integer>(Collections.nCopies(k, 0));
    var r = ThreadLocalRandom.current();

    try {
      for (int i = 0; i < k; i++) {
        a.set(i, dis.readInt());
      }
    } catch (IOException e) {
      closeUnchecked(dis);
      return Collections.emptyList();
    }

    int n = k;
    while (true) {
      try {
        int v = dis.readInt();
        n++;
        int choice = r.nextInt(n);
        if (choice < k) {
          a.set(choice, v);
        }
      } catch (IOException ignore) {
        break;
      }
    }
    closeUnchecked(dis);

    return a;
  }

  private static void closeUnchecked(InputStream in) {
    try {
      in.close();
    } catch (Exception ignore) {}
  }
}

package epi.lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;
import static java.nio.charset.StandardCharsets.*;

public class Reverse {
  public static <T> Node<T> reverse(Node<T> head) {
    if (head == null || head.next() == null) {
      return head;
    }

    Node<T> prev = null, cur = head;
    while (true) {
      Node<T> next = cur.next();
      cur.setNext(prev);
      prev = cur;
      if (next != null) {
        cur = next;
      } else {
        break;
      }
    }

    return cur;
  }
}

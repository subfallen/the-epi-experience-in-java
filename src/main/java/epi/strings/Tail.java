package epi.strings;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;
import static java.lang.Math.*;
import static java.nio.charset.StandardCharsets.*;

public class Tail {
    public static List<String> from(String s, int n) throws IOException {
        var f = new RandomAccessFile(s, "r");
        var end = f.length() - 1;
        var fp = end - 1;

        var lines = new LinkedList<String>();
        while (fp >= 0 && lines.size() < n) {
            f.seek(fp);
            char here = (char)f.readUnsignedByte();
            if (here == '\n' || fp == 0) {
                var line = new byte[(int)(end - fp - 1)];
                f.read(line, 0, line.length);
                lines.addFirst(new String(line, UTF_8));
                end = fp;
            }
            fp--;
        }
        return lines;
    }
}

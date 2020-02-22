package epi.strings;

public class AtoiItoa {
    public static String itoa(int i) {
        boolean negative = (i < 0);
        i = Math.abs(i);
        if (i == 0) {
            return "0";
        } else {
            var sb = new StringBuilder();
            while (i > 0) {
                int d = i % 10;
                sb.append((char)('0' + d));
                i /= 10;
            }
            if (negative) {
                sb.append('-');
            }
            sb.reverse();
            String result = sb.toString();
            return result;
        }
    }

    public static int atoi(String s) {
        boolean negative = false;
        int i = 0;
        for (char d : s.toCharArray()) {
            if (d == '-') {
                negative = true;
            } else {
                i = i * 10 + (d - '0');
            }
        }
        return i * (negative ? -1 : 1);
    }
}

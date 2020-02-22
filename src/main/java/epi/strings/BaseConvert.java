package epi.strings;

public class BaseConvert {
    public static String fromTo(int bIn, int bOut, String n) {
        int i = 0;
        boolean negative = false;
        for (char c : n.toCharArray()) {
            if (c == '-') {
                negative = true;
            } else {
                i = i * bIn + asDigit(c);
            }
        }
        if (i == 0) {
            return "0";
        }

        var sb = new StringBuilder();
        while (i > 0) {
            sb.append(asChar(i % bOut));
            i /= bOut;
        }
        if (negative) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }

    private static int asDigit(char c) {
        return CHARS.indexOf(c);
    }

    private static char asChar(int d) {
        return CHARS.charAt(d);
    }

    private static String CHARS = "0123456789ABCDEF";
}

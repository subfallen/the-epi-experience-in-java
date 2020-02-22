package epi.strings;

public class SpreadsheetId {
    public static int from(String id) {
        int n = 0;
        for (char c : id.toCharArray()) {
            n = n * 26 + (c - 'A' + 1);
        }
        return n;
    }
}

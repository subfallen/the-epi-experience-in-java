package epi.strings;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Collections.*;
import static java.lang.Character.*;

public class AllMnemonics {
    public static List<String> forNumber(String no) {
        return new Mnemonics(no.toCharArray()).generate();
    }

    private static class Mnemonics {
        private static final Map<Character, Character[]> DIGIT_LETTERS;
        static {
            DIGIT_LETTERS = IntStream.rangeClosed(2, 9)
                .boxed()
                .collect(toMap(
                            i -> Character.valueOf((char)('0' + i)),
                            i -> IntStream.range(0, 3 + ((i == 9 || i == 7) ? 1 : 0))
                                    .mapToObj(j -> 
                                        (char)('A' + (3 * (i - 2)) + j + (i > 7 ? 1 : 0)))
                                    .toArray(n -> new Character[n])));
        }

        private final char[] digits;
        private List<String> all;

        public Mnemonics(char[] digits) {
            this.digits = digits;
        }

        public List<String> generate() {
            if (all != null) {
                return all;
            }
            all = new ArrayList<>();
            char[] mnemonic = new char[digits.length];    
            generateRecursively(0, mnemonic);
            return all;
        }

        private void generateRecursively(int fromDigit, char[] mnemonic) {
            if (fromDigit == digits.length) {
                all.add(new String(mnemonic));
            } else {
                Character[] choices = DIGIT_LETTERS.get(digits[fromDigit]);
                for (Character c : choices) {
                    mnemonic[fromDigit] = c;
                    generateRecursively(fromDigit + 1, mnemonic);
                }
            }
        }
    }
}

package epi.strings

import spock.lang.*
import static epi.strings.WordReverse.*

class WordReverseSpec extends Specification {
    def 'works'() {
        expect:
        reverseWordsByHand('Bob likes Alice') == 'Alice likes Bob'
    }
}

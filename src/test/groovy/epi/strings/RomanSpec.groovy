package epi.strings

import spock.lang.*
import static epi.strings.Roman.*

class RomanSpec extends Specification {
    def 'works'() {
        expect:
        ['XXXXXIIIIIIIII', 'LVIIII', 'LIX'].collect { convert it } == [59, 59, 59] 
    }
}

package epi.strings

import spock.lang.*
import static epi.strings.AllMnemonics.*

class AllMnemonicsSpec extends Specification {
    def 'works'() {
        expect:
        ['A', 'B', 'C'] == forNumber('2')
        [
            'AW', 'AX', 'AY', 'AZ', 'BW', 'BX', 'BY', 'BZ', 'CW', 'CX', 'CY', 'CZ'
        ] == forNumber('29')
    }
}

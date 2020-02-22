package epi.strings

import spock.lang.*
import static epi.strings.SpreadsheetId.*

class SpreadsheetIdSpec extends Specification {
    @Unroll
    def 'converts #cellId to #n'() {
        given:
        def expected = n

        when:
        def actual = from(cellId)

        then:
        expected == actual

        where:
        cellId << ['D', 'AA', 'ZZ']
        n << [4, 27, 702]
    }
}

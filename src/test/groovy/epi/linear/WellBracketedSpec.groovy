package epi.linear

import spock.lang.*
import epi.linear.WellBracketed

class WellBracketedSpec extends Specification {
    def 'degenerate ok'() {
        expect:
        WellBracketed.isValid('[]')
        WellBracketed.isValid('()')
        WellBracketed.isValid('{}')
    }

    def 'all must match'() {
        expect:
        !WellBracketed.isValid('[]{')
    }

    def 'from the book'() {
        expect:
        WellBracketed.isValid('[()[]{()()}]')
    }
}

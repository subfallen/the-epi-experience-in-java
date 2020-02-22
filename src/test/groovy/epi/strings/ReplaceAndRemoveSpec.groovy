package epi.strings

import spock.lang.*
import static epi.strings.ReplaceAndRemove.*

class ReplaceAndRemoveSpec extends Specification {
    def 'handles example'() {
        given:
        def a = ['a', 'c', 'd', 'b', 'b', 'c', 'a'] as char[]

        when:
        process(a, 7)

        then:
        a == ['d', 'd', 'c', 'd', 'c', 'd', 'd']
    }
}

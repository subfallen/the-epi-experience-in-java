package epi.strings

import spock.lang.*
import static epi.strings.RabinKarp.*

class RabinKarpSpec extends Specification {
    def 'works'() {
        given:
        def s = 'ABC'
        def t = 'ZXYABZAXYABXABCZYAGLAKS'

        expect:
        t.indexOf(s) == search(s, t)
    }
}

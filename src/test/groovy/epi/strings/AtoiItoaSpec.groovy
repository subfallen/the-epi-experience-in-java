package epi.strings

import spock.lang.*
import static epi.strings.AtoiItoa.*

class AtoiItoaSpec extends Specification {
    def 'works for positive numbers'() {
        given:
        def orig = [5, 66, 9090]

        when:
        def strings = orig.collect { itoa(it) as String }
        println strings
        def ints = strings.collect { atoi(it) }

        then:
        strings == ['5', '66', '9090']
        ints == orig
    }

    def 'works for negative numbers'() {
        given:
        def orig = [-5, -66, -9090]

        when:
        def strings = orig.collect { itoa(it) as String }
        println strings
        def ints = strings.collect { atoi(it) }

        then:
        strings == ['-5', '-66', '-9090']
        ints == orig
    }
}

package epi.arrays

import spock.lang.*
import static epi.arrays.DutchFlag.Color.*
import static epi.arrays.DutchFlag.partition

class DutchFlagSpec extends Specification {
    def 'works for red'() {
        given:
        def a = [ WHITE, RED, RED, WHITE, GREEN, RED ]

        when:
        partition(a, 1)

        then:
        a == [ RED, RED, RED, WHITE, GREEN, WHITE ] 
    }

    def 'works for white'() {
        given:
        def a = [ WHITE, RED, RED, WHITE, GREEN, RED ]

        when:
        partition(a, 0)

        then:
        a == [ RED, RED, RED, WHITE, WHITE, GREEN ] 
    }

    def 'works for green'() {
        given:
        def a = [ WHITE, RED, RED, WHITE, GREEN, RED ]

        when:
        partition(a, 4)

        then:
        a == [ RED, RED, WHITE, WHITE, RED, GREEN ] 
    }
}

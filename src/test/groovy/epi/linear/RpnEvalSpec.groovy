package epi.linear

import spock.lang.*
import epi.linear.RpnEval

class RpnEvalSpec extends Specification {
    def 'degenerate ok'() {
        given:
        def rpn = '12345'

        when:
        def val = RpnEval.valueOf(rpn)

        then:
        val == 12345
    }

    def 'behaves as expected'() {
        given:
        def rpn = '1,2,+,3,+,4,5,+,+'

        when:
        def val = RpnEval.valueOf(rpn)

        then:
        val == 15
    }

    def 'behaves as expected with a mix of ops'() {
        given:
        def rpn = '4,2,/,3,*,4,-'

        when:
        def val = RpnEval.valueOf(rpn)

        then:
        val == 2
    }
}

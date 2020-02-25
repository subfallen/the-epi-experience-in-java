package epi.strings

import spock.lang.*
import static epi.strings.RunLength.*

class RunLengthSpec extends Specification {
    def 'works'() {
        expect:
        rlEncode('aaaabcccaa') == '4a1b3c2a' 
        rlDecode('4a1b3c2a') == 'aaaabcccaa'
        rlEncode('aaaaaaaaaa') == '10a'
        rlDecode('10a') == 'aaaaaaaaaa'
    }
}

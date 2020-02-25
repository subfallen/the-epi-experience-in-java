package epi.strings

import spock.lang.*
import static epi.strings.LookAndSayN.*

class LookAndSayNSpec extends Specification {
    def 'works'() {
        expect:
        (1..8).collect { lookAndSay(it) } == [
            '1', '11', '21', '1211', '111221', '312211', '13112221', '1113213211'
        ]
    }
}

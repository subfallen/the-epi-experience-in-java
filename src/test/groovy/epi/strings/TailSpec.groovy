package epi.strings

import spock.lang.*
import static epi.strings.Tail.*

class TailSpec extends Specification {
    def 'works'() {
        expect:
        from('src/main/resource/someLines.txt', 5) == [
            'Line 6',
            'Line 7',
            'Line 8',
            'Line 9',
            'Line 10'
        ]
    }
}

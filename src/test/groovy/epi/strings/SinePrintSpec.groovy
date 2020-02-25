package epi.strings

import spock.lang.*
import static epi.strings.SinePrint.*

class SinePrintSpec extends Specification {
    def 'works'() {
        expect:
        waveForm('Hello World!') == 'e lHloWrdlo!'
    }
}

package epi.strings

import spock.lang.*
import static epi.strings.BaseConvert.*

class BaseConvertSpec extends Specification {
    @Unroll
    def 'converts #n in b#bIn to b#bOut'() {
        given:
        def expected = Integer.toString(Integer.parseInt(n, bIn), bOut)

        when:
        def actual = fromTo(bIn, bOut, n)

        then:
        expected == actual

        where:
        bIn << [2, 5, 11, 16]
        n << ['01010101', '1231234', 'A1A1A1', 'BBCAFE']
        bOut << [3, 2, 16, 8]
    }
}

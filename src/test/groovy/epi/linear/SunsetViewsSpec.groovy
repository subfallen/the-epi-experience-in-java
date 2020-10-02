package epi.linear

import spock.lang.*
import epi.linear.SunsetViews
import static epi.linear.JumpListNode.*;

class SunsetViewsSpec extends Specification {
    def 'handles misc case'() {
        given:
        def heights = [5, 10, 7, 8, 12, 10, 15]
        and:
        def expected = [0, 1, 4, 6]

        when:
        def actual = SunsetViews.idsWithView(heights) 

        then:
        actual == expected
    }
}

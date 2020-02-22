package epi.arrays

import java.util.stream.*
import spock.lang.*
import static epi.arrays.Pascal.*
import java.math.MathContext
import static epi.test.ProbUtils.*

class PascalSpec extends Specification {
    def 'as expected for n=5'() {
        given:
        def tri = upToRow(5)

        expect:
        tri[0] == [1]
        tri[1] == [1, 1]
        tri[2] == [1, 2, 1]
        tri[3] == [1, 3, 3, 1]
        tri[4] == [1, 4, 6, 4, 1]
    }
}

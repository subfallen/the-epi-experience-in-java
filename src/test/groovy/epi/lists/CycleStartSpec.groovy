package epi.lists

import spock.lang.*
import epi.lists.Node
import static epi.lists.CycleStart.*

class CycleStartSpec extends Specification {
    def 'worksWithOffsetCycle'() {
        given:
        def p = Node.cycleTerminatedListOf(List.of('a', 'c', 'e', 'g', 'i'), 'e')

        when:
        def o = cycleStart(p)

        then:
        o.get().value() == 'e'
    }

    def 'worksWithNoCycle'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'g', 'i')

        when:
        def o = cycleStart(p)

        then:
        o.isEmpty()
    }

    def 'worksWithDegenerateCycle'() {
        given:
        def p = Node.cycleTerminatedListOf(List.of('a', 'c', 'e', 'g', 'i'), 'i')

        when:
        def o = cycleStart(p)

        then:
        o.get().value() == 'i'
    }

    def 'worksWithCompleteCycle'() {
        given:
        def p = Node.cycleTerminatedListOf(List.of('a', 'c', 'e', 'g', 'i'), 'a')

        when:
        def o = cycleStart(p)

        then:
        o.get().value() == 'a'
    }
}

package epi.linear

import java.util.*
import spock.lang.*
import epi.linear.InPlaceStackSort
import static epi.linear.JumpListNode.*;
import static java.util.stream.Collectors.*;

class InPlaceStackSortSpec extends Specification {
    def 'handles misc case'() {
        given:
        def a = [5, 10, 7, 8, 12, 10, 15]
        def e = a.stream().sorted(Comparator.reverseOrder()).collect(toList())
        and:
        Deque<Integer> stack = new ArrayDeque<>()

        when:
        a.each {
            stack.push it
        }
        and:
        InPlaceStackSort.inPlaceSort(stack)
        and:
        def result = new ArrayList<>(stack)

        then:
        result == e
    }
}

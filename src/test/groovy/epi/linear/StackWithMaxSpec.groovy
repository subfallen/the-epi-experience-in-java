package epi.linear

import spock.lang.*
import epi.linear.StackWithMax

class StackWithMaxSpec extends Specification {
    def 'behaves as expected'() {
        given:
        def sm = new StackWithMax<Integer>()

        when:
        sm.push(5)
        sm.push(8)
        sm.push(3)

        then:
        sm.max() == 8
    }

    def 'behaves as expected with duplicates'() {
        given:
        def sm = new StackWithMax<Integer>()

        when:
        sm.push(5)
        sm.push(8)
        sm.push(8)
        sm.push(3)
        sm.pop()
        sm.pop()

        then:
        sm.max() == 8
    }

    def 'behaves as expected after pops'() {
        given:
        def sm = new StackWithMax<Integer>()

        when:
        sm.push(5)
        sm.push(8)
        sm.push(8)
        sm.push(3)
        sm.pop()
        sm.pop()
        sm.pop()

        then:
        sm.max() == 5
    }
}

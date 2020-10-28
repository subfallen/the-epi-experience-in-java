package epi.linear

import spock.lang.*
import epi.linear.StackBasedQ

class StackBasedQSpec extends Specification {
    def 'from the book'() {
        given:
        def subject = new StackBasedQ<String>()
        def standard = new ArrayDeque<String>()

        when:
        'abcd'.each {
            subject.offer it
            standard.offer it
        }
        subject.poll()
        standard.poll()
        subject.poll()
        standard.poll()
        'efgh'.each {
            subject.offer(it)
            standard.offer(it)
        }
        and:
        def expected = []
        def actual = []
        while (true) {
            def n = standard.poll()
            if (n) {
                expected << n
                actual << subject.poll()
            } else {
                break
            }
        }

        then:
        actual == expected
    }
}

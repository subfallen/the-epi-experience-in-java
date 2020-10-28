package epi.linear

import spock.lang.*
import epi.linear.CircularQ

class CircularQSpec extends Specification {
    def 'from the book'() {
        given:
        def subject = new CircularQ<String>(3)

        when:
        'abcd'.each {
            subject.offer it
        }
        subject.poll()
        subject.poll()
        'efgh'.each {
            subject.offer(it)
        }

        then:
        'cdefgh' == subject.toString()
    }
}

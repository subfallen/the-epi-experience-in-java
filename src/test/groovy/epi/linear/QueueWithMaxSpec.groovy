package epi.linear

import spock.lang.*
import epi.linear.QueueWithMax

class QueueWithMaxSpec extends Specification {
    def 'from the book'() {
        given:
        def subject = new QueueWithMax<Integer>()
        def standard = new ArrayList<Integer>()

        when:
        [1, 2, 2, 1, 3, 4].each {
            subject.offer it
            standard.add(it)
        }

        then:
        println(subject)
        subject.max() == Collections.max(standard)
        subject.poll()
        subject.max() == Collections.max(standard)
        subject.poll()
        subject.max() == Collections.max(standard)
        subject.poll()
        subject.max() == Collections.max(standard)
        subject.poll()
        subject.max() == Collections.max(standard)
        subject.poll()
        subject.max() == Collections.max(standard)
    }
}

package epi.heaps

import spock.lang.*
import epi.heaps.HeapStack

class HeapStackSpec extends Specification {
    def 'works as as a heap'() {
        given:
        def subject = new HeapStack<Integer>()

        when:
        (1..<10).each {
            subject.push(it)
        }

        then:
        (1..<10).every {
            (10 - it) == subject.pop()
        }
    }
}

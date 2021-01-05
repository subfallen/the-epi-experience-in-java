package epi.heaps

import spock.lang.*
import epi.heaps.OnlineMedian

class OnlineMedianSpec extends Specification {
    def 'works for odd observed'() {
        given:
        def subject = new OnlineMedian()

        when:
        (1..7).each { subject.observe it }
        
        then:
        subject.medianSoFar() == 4.0
    }

    def 'works for even observed'() {
        given:
        def subject = new OnlineMedian()

        when:
        (1..10).each { subject.observe it }
        
        then:
        subject.medianSoFar() == 5.5
    }
}


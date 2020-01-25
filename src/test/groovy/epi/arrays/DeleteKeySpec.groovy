package epi.arrays

import spock.lang.*
import static epi.arrays.DeleteKey.del

class DeleteKeySpec extends Specification {
    @Unroll
    def 'deletes #instance.key from #instance.l correctly'() {
        given:
        def actual = instance.l
        def keyCount = Collections.frequency(actual, instance.key)
        and:
        println "Deleting $keyCount of $instance.key from $actual"
    
        when:
        del(actual, instance.key)
        and:
        println " --> $actual"

        then:
        (0..<keyCount).every {
            actual[instance.l.size() - 1 - it] == instance.key
        }

        
        where:
        instance << (0..<10).collect {
            instance(20, 5)
        }
    }

    private def instance(int n, int maxValue) {
        def r = new Random()

        def l = (0..<n).collect {
            r.nextInt(maxValue)
        }
        [l: l, key: r.nextInt(maxValue)]
    }
}

package epi.arrays

import spock.lang.*
import static epi.arrays.ArbitraryPrecisionInc.inc

class ArbitraryPrecisionIncSpec extends Specification {
    @Unroll
    def 'works for #v'() {
        given:
        def input = asList(v)

        when:
        def expected = asList(v + 1)
        and:
        println "input: $input"
        def actual = inc(input)
        and:
        println "Expected-> $expected :: Actual-> $actual" 

        then:
        expected == actual

        where:
        v << (0..<10).collect { Math.abs(new Random().nextLong()) }
    }

    private List<Integer> asList(long l) {
        Integer[] vals = new Integer[(int)Math.floor(Math.log10(l)) + 1]
        int n = vals.length
        for (int i = 0; i < n; i++) {
            vals[n - 1 - i] = l % 10
            l /= 10
        }
        List<Integer> lInc = new ArrayList<Integer>()
        lInc.addAll(vals)
        lInc
    }
}

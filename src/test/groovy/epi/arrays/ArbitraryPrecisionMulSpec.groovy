package epi.arrays

import spock.lang.*
import static epi.arrays.ArbitraryPrecisionMul.mul

class ArbitraryPrecisionMulSpec extends Specification {
    @Unroll
    def 'works for #a * #b = #c'() {
        given:
        def aIn = asList(a)
        def bIn = asList(b)
        and:
        def expected = asList(a * b)

        when:
        def actual = mul(aIn, bIn)
        and:
        println "$aIn * $bIn = $actual :: (Expected = $expected)"

        then:
        expected == actual

        where:
        a << (0..<10).collect { 
            def r = new Random()
            def v = r.nextInt(10_000) * [-1L, 1L].get(r.nextInt(2))
            return v
        }
        b << (0..<10).collect { 
            new Random().nextInt(10_000) 
        }
        c = a * b
    }

    private List<Integer> asList(long l) {
        def isNegative = l < 0
        l = Math.abs(l)
        Integer[] vals = new Integer[(int)Math.floor(Math.log10(l)) + 1]
        int n = vals.length
        for (int i = 0; i < n; i++) {
            vals[n - 1 - i] = l % 10
            l /= 10
        }
        List<Integer> lInc = new ArrayList<Integer>()
        lInc.addAll(vals)
        if (isNegative) {
            lInc.set(0, -1 * lInc.get(0))
        }
        lInc
    }
}

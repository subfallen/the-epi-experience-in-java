package epi.arrays

import java.util.stream.*
import spock.lang.*
import static epi.arrays.NextPerm.*

class NextPermSpec extends Specification {
    @Unroll
    def 'identifies #l correctly'() {
        given:
        def expected = bruteForce(l)
        def input = Arrays.toString(l)

        when:
        def actual = from(l)
        and:
        println "$input :: actual = $actual, expected = $expected"

        then:
        expected == actual

        where:
        l << (0..<10).collect { instance() }
    }

    private int[] bruteForce(int[] p) {
        def suffix = new TreeSet<Integer>();
        for (int i = p.length - 1; i >= 0; suffix.add(p[i--])) {
          def higher = suffix.higher(p[i]);
          if (higher != null) {
            return Stream.of(
                Arrays.stream(p, 0, i).boxed(),
                Stream.of(higher),
                suffix.headSet(higher).stream(),
                Stream.of(p[i]),
                suffix.tailSet(higher + 1).stream())
              .flatMapToInt({s -> s.mapToInt({j -> j})})
              .toArray();
          }
        }
        EMPTY_PERM
    }

    private int[] instance() {
        def p = (0..<10).collect { it } 
        Collections.shuffle(p)
        p as int[]
    }
}

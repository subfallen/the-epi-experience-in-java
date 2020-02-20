package epi.arrays

import java.util.stream.*
import spock.lang.*
import static epi.arrays.ValidSudoku.*
import java.math.MathContext
import static epi.test.ProbUtils.*

class ValidSudokuSpec extends Specification {
    def 'sees duplicate'() {
        given:
        int[][] b = [
           [ 0, 1, 0, 3 ],
           [ 4, 0, 2, 0 ],
           [ 0, 0, 0, 4 ],
           [ 2, 3, 4, 0 ]
        ] as int[][]
    
        expect:
        hasDuplicate(b, 2)
    }
    def 'sees no duplicate'() {
        given:
        int[][] b = [
           [ 0, 1, 0, 3 ],
           [ 4, 0, 2, 0 ],
           [ 0, 0, 0, 4 ],
           [ 2, 3, 1, 0 ]
        ] as int[][]
    
        expect:
        hasDuplicate(b, 2) == false
    }
}

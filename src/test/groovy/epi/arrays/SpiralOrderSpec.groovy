package epi.arrays

import java.util.stream.*
import spock.lang.*
import static epi.arrays.SpiralOrder.*
import java.math.MathContext
import static epi.test.ProbUtils.*

class SpiralOrderSpec extends Specification {
    def 'as expected for 3x3'() {
        given:
        int[][] b = [
           [ 1, 2, 3 ],
           [ 4, 5, 6 ],
           [ 7, 8, 9 ]
        ] as int[][]
    
        expect:
        spiral(b) == [1,2,3,6,9,8,7,4,5]
    }
    def 'as expected for 4x4'() {
        given:
        int[][] b = [
           [  1,  2,  3,  4 ],
           [  5,  6,  7,  8 ],
           [  9, 10, 11, 12 ],
           [ 13, 14, 15, 16 ]
        ] as int[][]
    
        expect:
        spiral(b) == [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    }
}

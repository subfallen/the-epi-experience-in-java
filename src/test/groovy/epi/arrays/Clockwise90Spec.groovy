package epi.arrays

import java.util.stream.*
import spock.lang.*
import static epi.arrays.Clockwise90.*
import java.math.MathContext
import static epi.test.ProbUtils.*

class Clockwise90Spec extends Specification {
    def 'as expected for 4x4'() {
        given:
        int[][] a = fill2d(4)
        println Arrays.deepToString(a)

        when:
        rotate90(a)
        println Arrays.deepToString(a)
    
        then:
        a[0] == [13, 9, 5, 1]
        a[1] == [14, 10, 6, 2]
        a[2] == [15, 11, 7, 3]
        a[3] == [16, 12, 8, 4]
    }

    def 'as expected for 3x3'() {
        given:
        int[][] a = fill2d(3)
        println Arrays.deepToString(a)

        when:
        rotate90(a)
        println Arrays.deepToString(a)
    
        then:
        a[0] == [7,4,1]
        a[1] == [8,5,2]
        a[2] == [9,6,3]
    }

    private int[][] fill2d(int dim) {
        def a = new int[dim][]
        int i = 1
        (0..<dim).each {
            row ->
                a[row] = new int[dim]
                (0..<dim).each {
                    col ->
                        a[row][col] = i++   
                }
        }
        a
    }
}

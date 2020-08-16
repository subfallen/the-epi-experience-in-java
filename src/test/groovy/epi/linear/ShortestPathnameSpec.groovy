package epi.linear

import spock.lang.*
import epi.linear.ShortestPathname

class ShortestPathnameSpec extends Specification {
    def 'from the book'() {
        given:
        def path = '/usr/lib/../bin/gcc'
        and:
        def expected = '/usr/bin/gcc'

        when:
        def actual = ShortestPathname.normalized(path)

        then:
        actual == expected
    }

    def 'again from the book'() {
        given:
        def path = 'scripts//./../scripts/awkscripts/././'
        and:
        def expected = 'scripts/awkscripts'

        when:
        def actual = ShortestPathname.normalized(path)

        then:
        actual == expected
    }

    def 'starting with ..'() {
        given:
        def path = '../this/isnt/../is//something/./else'
        and:
        def expected = '../this/is/something/else'

        when:
        def actual = ShortestPathname.normalized(path)

        then:
        actual == expected
    }

    def 'starting with ../../..'() {
        given:
        def path = '../../../this/isnt/../is//something/./else'
        and:
        def expected = '../../../this/is/something/else'

        when:
        def actual = ShortestPathname.normalized(path)

        then:
        actual == expected
    }

    def 'understands backtracking'() {
        given:
        def path = '../a/b/c/../../../../d'
        and:
        def expected = '../../d'

        when:
        def actual = ShortestPathname.normalized(path)

        then:
        actual == expected
    }
}

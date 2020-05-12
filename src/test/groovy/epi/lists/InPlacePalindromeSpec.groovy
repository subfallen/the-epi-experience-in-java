package epi.lists

import spock.lang.*
import epi.lists.Node
import epi.lists.InPlacePalindrome

class InPlacePalindromeSpec extends Specification {
    def 'works as expected for odd'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'c', 'a')

        expect:
        InPlacePalindrome.test(p)
        and:
        Node.toString(p) == '[a, c, e, c, a]'
    }

    def 'works as expected for even'() {
        given:
        def p = Node.listOf('a', 'c', 'e', 'e', 'c', 'a')

        expect:
        InPlacePalindrome.test(p)
        and:
        Node.toString(p) == '[a, c, e, e, c, a]'
    }

    def 'rejects non-palindrome'() {
        given:
        def p = Node.listOf('a', 'b', 'e', 'e', 'c', 'a')

        expect:
        InPlacePalindrome.test(p) == false
        and:
        Node.toString(p) == '[a, b, e, e, c, a]'
    }
}

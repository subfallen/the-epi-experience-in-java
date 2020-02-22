package epi.strings

import spock.lang.*
import static epi.strings.IsPalindrome.*

class IsPalindromeSpec extends Specification {
    def 'works'() {
        expect:
        test('as!df  fd,,sa') 
        test('!!!!!!z!!!az')
        !test('a sdfffg!dsa')
    }
}

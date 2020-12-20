package epi.bintrees

import epi.trees.TreeNode
import epi.trees.TreeUtils
import spock.lang.*
import epi.bintrees.TreeFromTraversals
import epi.trees.TreeNode
import static epi.trees.TreeUtils.*

class PreWithMarkerReconSpec extends Specification {
    def 'works for the book'() {
        given:
        def markedPreorder = [
            'H', 'B', 'F', 
            null, null, 'E', 
            'A', null, null,
            null, 'C', null,
            'D', null, 'G',
            'I', null, null,
            null
        ]

        when:
        def recon = PreWithMarkerRecon.from(markedPreorder)

        then:
        valuesMatch(recon, traversalExample())
    }
}





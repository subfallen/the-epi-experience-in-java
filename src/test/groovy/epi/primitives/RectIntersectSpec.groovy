package epi.primitives

import spock.lang.*

import static epi.primitives.RectIntersect.*

class RectIntersectSpec extends Specification {
  def 'containment is recognized'() {
    given:
    def a = new Rect(0, 0, 5, 5)
    def b = new Rect(1, 1, 3, 3)

    when:
    def c = interOf(a, b)

    then:
    c.isPresent()
    c.get() == b
  }

  def 'disjointness is recognized'() {
    given:
    def a = new Rect(0, 0, 5, 2)
    def b = new Rect(0, 3, 5, 5)

    when:
    def c = interOf(a, b)

    then:
    c.isEmpty()
  }

  def 'line segment intersection'() {
    given:
    def a = new Rect(0, 0, 5, 2)
    def b = new Rect(0, 2, 5, 4)

    when:
    def c = interOf(a, b)

    then:
    c.isPresent()
    c.get() == new Rect(0, 2, 5, 2)
  }

  def 'intersection recognized'() {
    given:
    def b = new Rect(0, 2, 5, 5)
    def a = new Rect(3, 1, 7, 3)

    when:
    def c = interOf(a, b)

    then:
    c.isPresent()
    c.get() == new Rect(3, 2, 5, 3)
  }
}

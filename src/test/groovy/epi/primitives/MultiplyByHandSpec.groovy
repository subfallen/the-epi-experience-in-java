package epi.primitives

import spock.lang.*

import static epi.primitives.MultiplyByHand.given

class MultiplyByHandSpec extends Specification {
  @Unroll
  def 'multiplies #instance'() {
    given:
    def expected = instance.x * instance.y
    and:
    def actual = given(instance.x, instance.y)
    and:
    println "Product for $instance :: EXPECTED=$expected & ACTUAL=$actual"

    expect:
    expected == actual

    where:
    instance << (1..10).collect { randomInstance() }
  }

  private def randomInstance() {
    long x, y

    long UNSIGNED_MASK = 0xffffffff
    while (true) {
      x = new Random().nextInt() & UNSIGNED_MASK
      y = new Random().nextInt() & UNSIGNED_MASK
      if ((x * y) >= 0) {
        break
      } 
    } 

    [x: x, y: y]
  }
}

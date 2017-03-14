// package week3

object rationals {
  val x = new Rational(1, 2)                      //> x  : Rational = Rational@51521cc1
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 2
}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
}
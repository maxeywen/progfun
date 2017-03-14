// package week3

object rationals {
  val x = new Rational(1, 2)                      //> x  : Rational = 1/2
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 2
  
  val y = new Rational(2,3)                       //> y  : Rational = 2/3
  x.add(y)                                        //> res2: Rational = 7/6
}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
  
  def add(that: Rational) =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom)
      
  override def toString = numer + "/" + denom
}
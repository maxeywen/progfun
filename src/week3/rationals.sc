// package week3

object rationals {
  val x = new Rational(1, 3)                      //> x  : Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Rational = 3/2
   
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  
  x.sub(y).sub(z)                                 //> res2: Rational = -79/42
}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
  
  def add(that: Rational) =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom)
      
  def neg: Rational = new Rational(-numer, denom)
  
  def sub(that: Rational) = add(that.neg)
      
  override def toString = numer + "/" + denom
}
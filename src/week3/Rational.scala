package week3

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator can not equal zero")
  
  def this(x: Int) = this(x, 1)
  
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  
  // private val g = gcd(x, y)
  def numer = x
  def denom = y
  
  def < (that: Rational) = numer * that.denom < denom * that.numer
  
  def max(that: Rational) = if (this < that) that else this
  
  def + (that: Rational) =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom)
      
  def unary_- : Rational = new Rational(-numer, denom)
  
  def - (that: Rational) = this + -that
      
  override def toString = {
    val g = gcd(numer, denom)
    numer / g + "/" + denom /g
  }
}
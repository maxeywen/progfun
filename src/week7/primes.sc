package week7

object primes {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def from(n: Int): Stream[Int] = n #:: from(n+1) //> from: (n: Int)Stream[Int]
  
  
  
  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]
    
}
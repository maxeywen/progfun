package week6

object test {
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW
  
  s exists (c => c.isUpper)                       //> res2: Boolean = true
  s forall (c => c.isUpper)                       //> res3: Boolean = false
  
  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  s flatMap (c => List('.', c))                   //> res5: String = .H.e.l.l.o. .W.o.r.l.d
  
  xs.sum                                          //> res6: Int = 50
  xs.max                                          //> res7: Int = 44
  
  (1 to 3) flatMap (x => (1 to 5) map (y => (x, y)))
                                                  //> res8: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (1,3), (1,4), (1,5), (2,1), (2,2), (2,3), (2,4), (2,5), (3,1), (3,2), (3,
                                                  //| 3), (3,4), (3,5))
  
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum      //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
    
  val vs = Vector(1.0, 2.0, 3.0)                  //> vs  : scala.collection.immutable.Vector[Double] = Vector(1.0, 2.0, 3.0)
  scalarProduct(vs, vs)                           //> res9: Double = 14.0
  
  def scalarProductPM(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{case (x,y) => x * y}.sum      //> scalarProductPM: (xs: Vector[Double], ys: Vector[Double])Double
    
  scalarProduct(vs, vs)                           //> res10: Double = 14.0
  
  def isPrime(n: Int) =
   (2 until n).forall(d => n % d != 0)            //> isPrime: (n: Int)Boolean
  
  isPrime(5)                                      //> res11: Boolean = true
  isPrime(11)                                     //> res12: Boolean = true
  isPrime(12)                                     //> res13: Boolean = false
}
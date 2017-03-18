package week6

object pairs {
  def isPrime(n: Int) =
   (2 until n).forall(d => n % d != 0)            //> isPrime: (n: Int)Boolean
   
  val n = 7                                       //> n  : Int = 7
  
  (1 until n)                                     //> res0: scala.collection.immutable.Range = Range(1, 2, 3, 4, 5, 6)
  
  (1 until n) map (i => i)                        //> res1: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3, 4, 5, 6)

  (1 until n) map (i =>
    (1 until i) map (j => (i, j)))                //> res2: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Index
                                                  //| edSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2)), V
                                                  //| ector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector((6,1)
                                                  //| , (6,2), (6,3), (6,4), (6,5)))
    
    
  val xss = (1 until n) map (i =>
    (1 until i) map (j => (i, j)))                //> xss  : scala.collection.immutable.IndexedSeq[scala.collection.immutable.Inde
                                                  //| xedSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2)), 
                                                  //| Vector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector((6,1
                                                  //| ), (6,2), (6,3), (6,4), (6,5)))
  xss.flatten                                     //> res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))
    
  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j)))                //> res4: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))
    
  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j)))  filter (pair => isPrime(pair._1 + pair._2))
                                                  //> res5: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
    
  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i+j)
  } yield (i, j)                                  //> res6: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
    
  
}
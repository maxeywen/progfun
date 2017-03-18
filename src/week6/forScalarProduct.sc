package week6

object forScalarProduct {
  val xs = List(1.0, 2.0, 3.0)                    //> xs  : List[Double] = List(1.0, 2.0, 3.0)
  val ys = List(1.0, 2.0, 3.0)                    //> ys  : List[Double] = List(1.0, 2.0, 3.0)
  
  (for {
    (x,y) <- xs zip ys
  } yield x * y ).sum                             //> res0: Double = 14.0
}
package week5

object foldReduce {
  val l = List(1, 2, 3, 4, 5)                     //> l  : List[Int] = List(1, 2, 3, 4, 5)

  def sumReduce(xs: List[Int]) = (0 :: xs) reduceLeft (_ + _)
                                                  //> sumReduce: (xs: List[Int])Int
  def sumFold(xs: List[Int]) = (xs foldLeft 0)(_ + _)
                                                  //> sumFold: (xs: List[Int])Int
  sumReduce(l)                                    //> res0: Int = 15
  sumFold(l)                                      //> res1: Int = 15

  def productReduce(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)
                                                  //> productReduce: (xs: List[Int])Int
  def productFold(xs: List[Int]) = (xs foldLeft 1)(_ * _)
                                                  //> productFold: (xs: List[Int])Int
  productReduce(l)                                //> res2: Int = 120
  productFold(l)                                  //> res3: Int = 120

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())(f(_) :: _)           //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
  
  mapFun[Int,Int](l, x => x * x )                 //> res4: List[Int] = List(1, 4, 9, 16, 25)

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)((x,y) => 1 + y)              //> lengthFun: [T](xs: List[T])Int
    
  lengthFun[Int](l)                               //> res5: Int = 5
}
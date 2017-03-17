package week5

object squareList {

  def squareListPM(xs: List[Int]): List[Int] =
    xs match {
      case Nil => Nil
      case y :: ys => (y * y) :: squareListPM(ys)
    }                                             //> squareListPM: (xs: List[Int])List[Int]

  def squareListMAP(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareListMAP: (xs: List[Int])List[Int]
    
  val l = List(1,2,3,4,5)                         //> l  : List[Int] = List(1, 2, 3, 4, 5)
  
  squareListPM(l)                                 //> res0: List[Int] = List(1, 4, 9, 16, 25)
  squareListMAP(l)                                //> res1: List[Int] = List(1, 4, 9, 16, 25)

}
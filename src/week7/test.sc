package week7

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val problem = new Pouring(Vector(4,9))          //> problem  : week7.Pouring = week7.Pouring@5a61f5df
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with w
                                                  //| eek7.test.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), Pour(
                                                  //| 0,1), Pour(1,0))
  
  problem.solution(6)                             //> res1: Stream[week7.test.problem.Path] = Stream(Fill(1) Pour(1,0) Empty(0) Po
                                                  //| ur(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0)--> Vector(4, 6), ?)
}
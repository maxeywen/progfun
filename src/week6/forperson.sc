package week6

object forperson {
  case class Person(name: String, age: Int)
  
  val persons = List(
    new Person("Bob", 15),
    new Person("Rob", 35),
    new Person("Tom", 23),
    new Person("Steve", 18)
  )                                               //> persons  : List[week6.forperson.Person] = List(Person(Bob,15), Person(Rob,35
                                                  //| ), Person(Tom,23), Person(Steve,18))
  
  persons filter (p => p.age > 20) map (p => p.name)
                                                  //> res0: List[String] = List(Rob, Tom)
  
  for (p <- persons if p.age > 20) yield p.name   //> res1: List[String] = List(Rob, Tom)
}
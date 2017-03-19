package week8

object test {
  val f: String => String =
    { case "ping" => "pong" }                     //> f  : String => String = <function1>
    
  f("ping")                                       //> res0: String = pong
  
  val f2: PartialFunction[String, String] =
    { case "ping" => "pong" }                     //> f2  : PartialFunction[String,String] = <function1>
  
  f2.isDefinedAt("ping")                          //> res1: Boolean = true
  f2.isDefinedAt("foo")                           //> res2: Boolean = false
}
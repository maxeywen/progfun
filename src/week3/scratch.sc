import week3.Rational

object scratch {
  new Rational(1, 2)                              //> res0: Rational = 1/2
  
  def error(msg: String) =
    throw new Error(msg)                          //> error: (msg: String)Nothing
    
  // error("error message")
  
  val x = null                                    //> x  : Null = null
  val y: String = x                               //> y  : String = null

}
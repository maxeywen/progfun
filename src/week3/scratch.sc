import week3.Rational

object scratch {
  new Rational(1, 2)                              //> res0: Rational = 1/2
  
  def error(msg: String) =
    throw new Error(msg)                          //> error: (msg: String)Nothing
    
  error("error message")                          //> java.lang.Error: error message
                                                  //| 	at scratch$$anonfun$main$1.error$1(scratch.scala:7)
                                                  //| 	at scratch$$anonfun$main$1.apply$mcV$sp(scratch.scala:9)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at scratch$.main(scratch.scala:3)
                                                  //| 	at scratch.main(scratch.scala)

}
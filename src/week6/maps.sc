package week6

object maps {
  val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[Char,Int] = Map(I -> 1, V -> 
                                                  //| 5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
  romanNumerals('I')                              //> res0: Int = 1
  romanNumerals get 'I'                           //> res1: Option[Int] = Some(1)
  romanNumerals get 'C'                           //> res2: Option[Int] = None
  
  def getNumber(romNum: Char) = romanNumerals.get(romNum) match {
    case Some(n) => n
    case None => -1
  }                                               //> getNumber: (romNum: Char)Int
  getNumber('I')                                  //> res3: Int = 1
}
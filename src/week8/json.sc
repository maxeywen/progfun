package week8

object json {
  abstract class JSON
  case class JSeq(elems: List[JSON])           extends JSON
  case class JObj(bindings: Map[String, JSON]) extends JSON
  case class JNum(num: Double)                 extends JSON
  case class JStr(str: String)                 extends JSON
  case class JBool(b: Boolean)                 extends JSON
  case object JNull                            extends JSON
  
  val data = JObj(Map(
    "firstName" -> JStr("John"),
    "lastName" -> JStr("Smith"),
    "address" -> JObj(Map(
      "streetAddress" -> JStr("21 2nd Street"),
      "state" -> JStr("NY"),
      "postalCode" -> JNum(10021)
    )),
    "phoneNumbers" -> JSeq(List(
      JObj(Map(
        "type" -> JStr("home"), "number" -> JStr("212 555-1234")
      )),
      JObj(Map(
        "type" -> JStr("fax"), "number" -> JStr("646 555-4567")
      )) )) ))                                    //> data  : week8.json.JObj = JObj(Map(firstName -> JStr(John), lastName -> JStr
                                                  //| (Smith), address -> JObj(Map(streetAddress -> JStr(21 2nd Street), state -> 
                                                  //| JStr(NY), postalCode -> JNum(10021.0))), phoneNumbers -> JSeq(List(JObj(Map(
                                                  //| type -> JStr(home), number -> JStr(212 555-1234))), JObj(Map(type -> JStr(fa
                                                  //| x), number -> JStr(646 555-4567)))))))
      
  def show(json: JSON): String = json match {
    case JSeq(elems) =>
        "[" + (elems map show mkString ", ") + "]"
    case JObj(bindings) =>
      val assocs = bindings map {
        case (key, value) => "\"" + key + "\": " + show(value)
      }
      "{" + (assocs mkString ", ") + "}"
    case JNum(num) => num.toString
    case JStr(str) => '\"' + str + '\"'
    case JBool(b) => b.toString
    case JNull => "null"
}                                                 //> show: (json: week8.json.JSON)String
  
  show(data)                                      //> res0: String = {"firstName": "John", "lastName": "Smith", "address": {"stre
                                                  //| etAddress": "21 2nd Street", "state": "NY", "postalCode": 10021.0}, "phoneN
                                                  //| umbers": [{"type": "home", "number": "212 555-1234"}, {"type": "fax", "numb
                                                  //| er": "646 555-4567"}]}
  
  type JBinding = (String, JSON)
   
  val data2 = JObj(Map(
    "firstName" -> JStr("Jim"),
    "lastName" -> JStr("Jones"),
    "address" -> JObj(Map(
      "streetAddress" -> JStr("22 3rd Street"),
      "state" -> JStr("NY"),
      "postalCode" -> JNum(10021)
    )),
    "phoneNumbers" -> JSeq(List(
      JObj(Map(
        "type" -> JStr("home"), "number" -> JStr("213 565-1234")
      )),
      JObj(Map(
        "type" -> JStr("fax"), "number" -> JStr("656 565-4567")
      )) )) ))                                    //> data2  : week8.json.JObj = JObj(Map(firstName -> JStr(Jim), lastName -> JSt
                                                  //| r(Jones), address -> JObj(Map(streetAddress -> JStr(22 3rd Street), state -
                                                  //| > JStr(NY), postalCode -> JNum(10021.0))), phoneNumbers -> JSeq(List(JObj(M
                                                  //| ap(type -> JStr(home), number -> JStr(213 565-1234))), JObj(Map(type -> JSt
                                                  //| r(fax), number -> JStr(656 565-4567)))))))
      
  val data3 = JObj(Map(
    "firstName" -> JStr("Tom"),
    "lastName" -> JStr("Jones"),
    "address" -> JObj(Map(
      "streetAddress" -> JStr("42 53rd Street"),
      "state" -> JStr("MA"),
      "postalCode" -> JNum(11021)
    )),
    "phoneNumbers" -> JSeq(List(
      JObj(Map(
        "type" -> JStr("home"), "number" -> JStr("214 497-1234")
      )),
      JObj(Map(
        "type" -> JStr("fax"), "number" -> JStr("356 656-4567")
      )) )) ))                                    //> data3  : week8.json.JObj = JObj(Map(firstName -> JStr(Tom), lastName -> JSt
                                                  //| r(Jones), address -> JObj(Map(streetAddress -> JStr(42 53rd Street), state 
                                                  //| -> JStr(MA), postalCode -> JNum(11021.0))), phoneNumbers -> JSeq(List(JObj(
                                                  //| Map(type -> JStr(home), number -> JStr(214 497-1234))), JObj(Map(type -> JS
                                                  //| tr(fax), number -> JStr(356 656-4567)))))))
      
  val dataList: List[JSON] = List(data, data2, data3)
                                                  //> dataList  : List[week8.json.JSON] = List(JObj(Map(firstName -> JStr(John), 
                                                  //| lastName -> JStr(Smith), address -> JObj(Map(streetAddress -> JStr(21 2nd S
                                                  //| treet), state -> JStr(NY), postalCode -> JNum(10021.0))), phoneNumbers -> J
                                                  //| Seq(List(JObj(Map(type -> JStr(home), number -> JStr(212 555-1234))), JObj(
                                                  //| Map(type -> JStr(fax), number -> JStr(646 555-4567))))))), JObj(Map(firstNa
                                                  //| me -> JStr(Jim), lastName -> JStr(Jones), address -> JObj(Map(streetAddress
                                                  //|  -> JStr(22 3rd Street), state -> JStr(NY), postalCode -> JNum(10021.0))), 
                                                  //| phoneNumbers -> JSeq(List(JObj(Map(type -> JStr(home), number -> JStr(213 5
                                                  //| 65-1234))), JObj(Map(type -> JStr(fax), number -> JStr(656 565-4567))))))),
                                                  //|  JObj(Map(firstName -> JStr(Tom), lastName -> JStr(Jones), address -> JObj(
                                                  //| Map(streetAddress -> JStr(42 53rd Street), state -> JStr(MA), postalCode ->
                                                  //|  JNum(11021.0))), phoneNumbers -> JSeq(List(JObj(Map(type -> JStr(home), nu
                                                  //| mber -> JStr(214 497-12
                                                  //| Output exceeds cutoff limit.
  
  for {
    JObj(bindings) <- dataList
    JSeq(phones) = bindings("phoneNumbers")
    JObj(phone) <- phones
    JStr(digits) = phone("number")
    if digits startsWith "212"
  } yield (bindings("firstName"), bindings("lastName"))
                                                  //> res1: List[(week8.json.JSON, week8.json.JSON)] = List((JStr(John),JStr(Smit
                                                  //| h)))
  
  for {
    JObj(bindings) <- dataList
    JStr(ln) = bindings("lastName")
    if ln == "Jones"
  } yield bindings("firstName")                   //> res2: List[week8.json.JSON] = List(JStr(Jim), JStr(Tom))
  
  
  
  
  
  
}
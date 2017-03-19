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
}
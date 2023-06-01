package part_1_variables

object TypesValuesVariables extends App {
  var aString: String = "Hello"
  val bString = "World"
  val aLong = 11L
  val aFloat = 2.0f
  val aDouble = 2.0
  val aChar = 'c'
  val aInt = 3

  println(aString,
    bString,
    aInt,
    aFloat,
    aDouble,
    aLong,
    aChar)
  aString = "New"
  println(aString, aString.getClass)



}


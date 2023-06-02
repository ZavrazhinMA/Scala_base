package part_1_variables.string

object StringOperations extends App {
  val aString = "Hello world"
  println(aString.length)
  println(aString.charAt(1))
  println(aString.substring(1, 3))
  println(aString.split(' ').toList)
  println(aString.startsWith("1"))
  println(aString.replace("lo", "l"))
  println(aString.toUpperCase())
  println(aString.toLowerCase())
  println(aString.reverse)
  println(aString.take(2))

  val bString = 43.toString
  println(bString.take(5).toUpperCase.toInt)

  println('1' +: "42" :+ '3') // выводит 1423
  println('a' +: "bc" :+ 'd') // abcd
  println("a" ++ "bc" :++ "d") // abcd
  println('a' + "bc" + 'd') // abcd

  val name = "John"
  println(s"Hello, $name") // выводит Hello, John
  val surname = "Smith"

  println(s"Hello, ${name + ' ' + surname}") // выводит Hello, JohnSmith

  val link = "https://\tstepik.org"
  println(s"The link is \t $link")
  println(s"The link is $link.toUpperCase")
  println(raw"$link")
}


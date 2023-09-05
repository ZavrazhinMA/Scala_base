package prog_func

object Patterns extends App {
  val someVal = 8

  val description = someVal match {
    case 1 => "action 1"
    case 2 => "action 2"
    case 3 => "action three"
    case _ => "default action"
  }

  println(description) // action three

  val aStandardList = List(5, 4)
  val listMatching = aStandardList match {
    case List(1, _, _, _) => "список из 4 элементов, где первый элемент равен 1"
    case List(2, _*) => "список произвольной длины, где первый элемент равен 2"
    case List(3, 2, 1) :+ 0 => "список List(3, 2, 1, 0)"
    case 5 :: List(_) => "список, где первым идет число 5 и еще один элемент"
    case _ => "default"
  }
  println(listMatching)

  val unknown: Any = List(1, 2)
  val typeMatch = unknown match {
    case list: List[Int] => "list of INTs"
    case _ => "default"
  }

  println(typeMatch) // list of INTs

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 30)
  val greeting = bob match {
    case Person(n, a) if a < 18 => s"I'm $n and I'm under 18"
    case Person(n, a) if n != "name" => s"I'm $n and I am $a years old"
    case _ => "I have no name"
  }
  println("+"*30 + "\n")

  /*Привязка имен (Name Binding)
  Довольно полезная вещь
  , если требуется как - то обратиться к найденному совпадению.

    Задается имя совпадения
  , ставится знак
  @, после которого прописывается сам шаблон:*/

val nameBindingMatch = List(6, 2) match {
  case nonEmptyList@List(1, _, _, _) => s"нашли $nonEmptyList"
  case someList@List(6, _*) => s"нашли список $someList"
}

println(nameBindingMatch) // нашли список List(6, 2)

  def guard(data: Any, maxLength: Int): String = {
    val result: String = data match {
      case list: List[Any] if (list.length <= maxLength) => "Задан список List допустимой длины"
      case list: List[Any] if (list.length > maxLength) => "Длина списка больше максимально допустимого значения"
      case string: String if (string.length <= maxLength) => "Длина строки не превышает максимально допустимого значения"
      case string: String if (string.length > maxLength) => "Получена строка недопустимой длины"
      case _ => "Что это? Это не строка и не список"
    }
    result
  }
  println(guard(List(1,2,3), 2))


  val aPartialFunction: PartialFunction[String, String] = {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }

  println(aPartialFunction.isDefinedAt("tue")) // false

  val aPartialFunction2: PartialFunction[String, String] = {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }


  val lifted = aPartialFunction2.lift // теперь на выходе имеем тип Option[String]

  println(lifted("fri")) // Some(Party Time)
  println(lifted("thu")) // None


  val chatbot1: PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }


  val chatbot = chatbot1.lift // теперь на выходе имеем тип Option[String]

  println("="*30 + "\n")

val a = scala.io.Source.stdin.getLines()
  println(a)
//  a.foreach(line => println(chatbot(line)))
  a.map(line => chatbot(line)).foreach(x => println(x))
}

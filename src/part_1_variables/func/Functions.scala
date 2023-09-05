package part_1_variables.func

object Functions extends App{
  def aPerson(name: String, surname: String): String = {
    s"$name $surname"

  }
  println(aPerson("John", "Smith"))

  def aParameterlessFunction(): Unit = println("Function with no parameters")

  aParameterlessFunction()
  aParameterlessFunction

  def aFunctionWithDefaultParameter(x: Int, y: String = "Default Parameter"): String = {
    s"x = $x and y = $y"
  }

  println(aFunctionWithDefaultParameter(1)) // выводит x = 1 and y = Default Parameter

  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def aCondition(): Boolean = if (1 < 2) true else false


  def someFunnc(x: =>Int, y: =>Int): Int = {
    if (aCondition()) x * 2
    else  x * y
  }
  println(someFunnc(3,5))
}

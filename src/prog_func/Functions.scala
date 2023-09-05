package prog_func

object Functions extends App{

  val product = (x: Int, y: Int) => x * y
//  val product: (Int, Int) => Int = (x, y) => x * y
//  val product: (Int, Int) => Int = _ * _

  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val res = someFunc(1)
  println(res)
  println(res(4))
  println(someFunc(3)(4))

//  ============================
def byName(n: => Int) = n + 1

  def byFunction(f: () => Int) = f() + 1

  def method: Int = 2

  def parenthesisMethod(): Int = 2

  byName(12)
  byName(method)
  byName(parenthesisMethod())
//  byName(() => 2)
  byName((() => 2)())
//  byName(parenthesisMethod _)

  def add(x: Int, y: => Int) = x + y

  def multiply(f: () => Int) = f() * 2

  def four: Int = 4

  def two(): Int = 2
  println("-------------------------")

  add(1, four)

  add(1, 2)


  multiply(two)

  multiply(() => 4)

  add(two(), four)

  multiply(two _)

  add(1, (() => 2)())
}

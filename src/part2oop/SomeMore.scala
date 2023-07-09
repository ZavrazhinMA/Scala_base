package part2oop

import java.lang

object SomeMore extends App {

  def countSumOfInt(nums: List[Int]): Int = nums.sum

  countSumOfInt(List(1, 2, 3)) // 6

  def countSum[A: Numeric](nums: List[A]): A = nums.sum

  println(countSum[Int](List(1, 2, 3)))
  println(countSum[Double](List(1.3, 2.2, 3.5))) // 7.0

  def intOrNothing(hasException: Boolean): Int =
    if (hasException) throw new RuntimeException("Exc is here")
    else 200

  try {
    intOrNothing(true)
  } catch {
    case e: RuntimeException => println("RTE here")
  } finally {
    println("OK")
  }


  // ==============================================================
  // дополните код
  trait Event {
    def id: String

    def evType: String

    def operation: String
  }

  case class UserEvent(id: String, evType: String, operation: String) extends Event

  case class SystemEvent(id: String, evType: String, operation: String) extends Event

  trait Registrable[T <: Event] {
    def update(event: T, status: String): T
  }

  object EventOps {
    val userEvent: Registrable[UserEvent] = new Registrable[UserEvent] {
      def update(event: UserEvent, status: String): UserEvent = event.copy(operation = status)
    }

    val systemEvent: Registrable[SystemEvent] = new Registrable[SystemEvent] {
      def update(event: SystemEvent, status: String): SystemEvent = event.copy(operation = status)
    }
  }

  class EventOps[T<: Event](event: T)(ops: Registrable[T]) {
    def update(status: String): T = ops.update(event, status)
  }

  val user1Event = UserEvent("1", "user_event", "account_create")
  val user1Ops = new EventOps(user1Event)(EventOps.userEvent)
  val user1EventUpd = user1Ops.update("permission_add")

  println(s"User1 | Operation: ${user1EventUpd.operation}")

  //===================================
  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  class InvariantList[A]
  val invariantFruitList: InvariantList[Fruit] = new InvariantList[Fruit]

  class ContravariantList[-A]
   val contravariantList: ContravariantList[Apple] = new ContravariantList[Fruit]
// ****************************************


  println(Int.MaxValue)
  class MyException extends Exception {
    println("Alarm alarm")
  }
  val alarm = new MyException
  throw alarm
  val exceptionVal: Unit = throw new NullPointerException
}
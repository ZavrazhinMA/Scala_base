package part2oop

object Inheritance extends App{
  class Person {
    def greet: String = "Hello"
  }

  class Student extends Person {
    val name = "Oleg"
  }

  val student = new Student
  println(s"${student.greet}  ${student.name}")


  class Person2(name: String, age: Int) {
    override def toString = "hello"
  }

  class Stud(name: String, age: Int, id: Int) extends Person2(name, age) {
  }
  val dd = new Stud("pgl", 12, 5)
  println(dd)

  // ===================================================================

  class Button(label: String = "test") {
    val lbl: String = label
    def click: String = s"button -$lbl- has been clicked"

  }

  class RoundedButton(label: String) extends Button {
    override val lbl: String = label
    override def click: String ="rounded " + RoundedButton.super.click
  }
  println(new RoundedButton("knopka").click)


// ======================================================================
  abstract class BaseDataSource(dataSourceName: String) {
  def save: String = {
    s"Some text"
  }

  def delete: String = {
    s"Text"
  }
  val user: String
  def connect: String
  }

  class PublicDSource(ds:String) extends BaseDataSource(ds) {
    val user = "publ"

    override def connect: String = {
      s"new text"
    }
  }

  // ------------anonymous
  val someSourse = new BaseDataSource("sommm") {
    override val user: String = "new"

    override def connect: String = "next"
  }

    // =======================ТРЕЙТЫ

  trait Optional_trait {
    def textArea: String
  }

  class BaseDataSource1(dataSourceName: String) {
    def save: String = {
      s"Some text"
    }
  class NewBase(ds:String) extends BaseDataSource1(ds) with Optional_trait {
    override def textArea: String = s"temp text"  }

  }

  //***********************FINAL*************************
  trait Configs {
    val ACCOUNT_TYPE_DEFAULT = "free"
    val ACCOUNT_TYPE_PAID = "paid"
    val SUBSCRIPTION_STATUS = "active"
  }

  object Settings {
    case class AccountSettings(
                                email: String,
                                password: String,
                                picture: String)

    case class SubscriptionSettings(
                                     payment: String,
                                     notifications: String,
                                     expiration: String)
  }

  trait Subscriber {
    def subscribe(settings: Settings.SubscriptionSettings): Unit = println("subscribed")
  }

  trait Unsubscriber {
    def unsubscribe(): Unit = println("unsubscribed")
  }

  abstract class Account(accountID: String, settings: Settings.AccountSettings) {
    def info(): Unit
  }

  class FreeAccount(
                     accountID: String,
                     settings: Settings.AccountSettings) extends Account(accountID: String, settings: Settings.AccountSettings) with Configs with Subscriber {

    override def info(): Unit = println(s"Account Type: $ACCOUNT_TYPE_DEFAULT")
  }

  class PaidAccount(
                     accountID: String,
                     settings: Settings.AccountSettings)
    extends Account(accountID: String, settings: Settings.AccountSettings) with Configs with Unsubscriber {

    override def info(): Unit = {
      println(s"Account Type: $ACCOUNT_TYPE_PAID")
      println(s"Subscription Status: $SUBSCRIPTION_STATUS")
    }
  }
  //--------------------------===================-------------------
  trait Device {
    def processDoc: Unit
  }

  trait Printer extends Device {
    override def processDoc: Unit = println("print your txt")
  }

  trait Scanner extends Device {
    override def processDoc: Unit = println("scan your txt")
  }

  class ComboDevice extends Printer with Scanner

  val device = new ComboDevice
  device.processDoc
}



package part2oop

object CaseClasses extends App{
  case class Person11(name: String, occupation: String)
  val bobi = new Person11(name = "Bob", occupation = "Dev")
  println(bobi)

//  ================================
case class Person(name: String, occupation: String)

  val bob = Person("Bob", "Developer")

  val anotherBob = bob.copy()
  println(bob) // Person(Bob,Developer)
  println(anotherBob) // Person(Bob,Developer)
  println(anotherBob==bob) // Person(Bob,Developer)

  val bobsTwin = bob.copy(name = "John")
  println(bobsTwin) // Person(John,Developer)

//  =======================================================
case class Course(title: String, instructor: String)

  object Course {
    def apply(instructor: String): Course = Course("AdvancedScala", instructor)
  }

  val scalaCourse = Course("Scala", "Bob")

//  val course = scalaCourse.copy()
//  val course = Course("Alice")
//  val course = new Course("Scala", "Bob")
//  val course = scalaCourse.copy("AdvancedScala")
  val course = Course("Scala", "Bob")
  println("====="* 10)
  println(course)
//  ---------------------------------------------------
case class Course1(title: String, instructor: String)

  val course1= Course1("Scala", "Bob")
  println(course.title)
}

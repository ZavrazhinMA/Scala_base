package part2oop

object ClassesOOP extends App {
  val student = new Student(2, "Alyosha")
  println(student.name)



 class Student(id: Int, val name: String) {
   val uni = "Univer"
   println(uni)
 }

//=====================================================
// OVERLOADING

  class Student2(id: Int, val name: String) {
    def getId(name: String, id: Int): String =
      s"${this.name} has ID ${this.id} and $name has ID $id"

    def getId: String = s"Here is $name winh $id"
  }


    val student2 = new Student2(1, "Oleg")
    println(student2.getId("Ignat", 23))
    println(student2.getId)


//=====================================================
// OVERLOADING CONSTRUCTORS
  class Student3(id: Int, val name: String) {
  def this(name: String) = this(0, name)
  def this() = this(0, "NONAME")
  println(id, name)
}
  val student3 = new Student3()
  val student3_1 = new Student3("Pedro")
  val student3_4 = new Student3(3, "Kesha")

  class Student4(id: Int = 0, val name: String = "UNKNOWN_PIDR") {
    println(id, name.capitalize)
  }

  val student4 = new Student4()
  val student4_1 = new Student4(6, "somehuy")
  val student4_4 = new Student4(3, "Kesha")

  class Instructor22(val id: Int, val name: String, val surname: String) {
    def fillName: String = {
    s"${this.name.capitalize}  ${this.surname.capitalize}"
  }
}
  val gg = new Instructor22(1, "jjj", "dggg")
  print(gg.fillName.toString)


//  ================================================
// начните писать код классов здесь
  class Instructor(val id: Int, val name: String, val surname: String) {
    def fullName(): String = {
  s"${this.name.capitalize} ${this.surname.capitalize}"
  }
  }

  class Course(val courseID: Int, val title: String, val releaseYear: Int, val instructor: Instructor) {
    def getID: Int = {
      (this.courseID.toString + this.instructor.id.toString).toInt
    }

    def isTaughtBy(istr: Instructor): Boolean = {
      if (istr.id == this.instructor.id) true else false
    }

    def copyCourse(newReleaseYear: Int): Course = {
      new Course(this.courseID, this.title, newReleaseYear, this.instructor)
    }
  }
}
package part2oop

object SyntacticSugar extends App{
  class Person(val name: String, occupation: String) {
    def worksAs(jobName: String): Boolean = jobName == occupation
    def speaksEnglish: Boolean = true
  }
  val bob = new Person("Bob", "Developer")
  println(bob.worksAs("Developer")) // true
  println(bob worksAs "Developer") // true
  println(bob.speaksEnglish) // точечная нотация
//  println(bob speaksEnglish) // постфиксная нотация
//===================================OPERATORS=========================
  println(1 + 2) // обычное обращение
  println(1.+(2)) // обращение через точку

  class Person1(val name: String, occupation: String) {
    def worksAs(jobName: String): Boolean = jobName == occupation

    def speaksEnglish: Boolean = true

    def &(person1: Person1): String = s"${this.name} and ${person1.name} are colleagues"
  }

  val bob1 = new Person1("Bob", "Developer")
  val alice = new Person1("Alice", "Data Engineer")

  println(bob1.&(alice)) // точечная нотация
  println(bob1 & alice) // инфиксная нотация

  class Person33(val name: String, occupation: String) {
    def apply(company: String): String = s"$name works as a $occupation in $company"
  }


  val bob2 = new Person33("Bob", "Developer")
  println(bob2 apply ("Sams"))


  class Person66(val name: String, occupation: String) {
    def worksAs(jobName: String): String = s"$name is a $jobName"
    def isDeveloper: String = this worksAs("Scala Developer")
  }

  val bob225 = new Person66("Bob", "Developer")
  println(bob225.isDeveloper)

  class Person666(val name2: String) {
    def name: String = s"$name2 NoSurname"

  }
  val bob4 = new Person666("Bob")
//  println((+bob4).name)

//  ==================================================


}

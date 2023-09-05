package prog_func

object Collections extends App {
  val emptySet: Set[Int] = Set()
  val aSet: Set[Int] = Set(10, 20, 30, 40)
  val anotherSet = Set(30, 40, 60)
  println(
    aSet.isEmpty,
    emptySet.isEmpty,
    aSet.head,
    aSet.tail,
    aSet.min,
    aSet.max,
  )
  println(
    aSet.intersect(anotherSet),
    aSet.&(anotherSet)
  )
  println(
    aSet ++ anotherSet,
    aSet.++(anotherSet)
  )

  println("==" * 20)

  val aSeq = Seq(1, 3, 2, 5)
  println(aSeq)
  println(aSeq.length,
    aSeq.reverse,
    aSeq.sorted
  )
  println(aSeq.search(3),
    aSeq(1))
  //  ================== ======
  println("==" * 20)
  val aMap: Map[String, Int] = Map()
  val colors = Map(("black", "#0000"), ("blue" -> "#3999")).withDefaultValue("hui")
  println(colors.contains("black"))
  println(colors("black"))
  println(colors("red"))
  print(colors.toList)
  //  ------------------------

  val fruits = List("apple", "banana")

  val mapResult = fruits.map(_.toUpperCase)
  val flatResult = fruits.flatMap(_.toUpperCase)

  println(mapResult) // List(APPLE, BANANA)
  println(flatResult) // List(A, P, P, L, E, B, A, N, A, N, A)
  val s = "Hello"
  val newStr: String = s.flatMap(c => (c + "."))
  println(newStr) // H.e.l.l.o.
  println(s.map(c => (c + "."))) // ArraySeq(H., e., l., l., o.)

  val List1 = List(1, 2)
  val List2 = List("a", "b")
  val combo = List1.flatMap(n => List2.map(c => c + n))
  println(combo)

  val progLanguages = List("java", "scala", "python")
  progLanguages.map(_.toUpperCase).foreach(println)

  println(progLanguages.map(_.toUpperCase))

  for {
    lng <- progLanguages
  } println(lng.toUpperCase)

  println(for {
    lng <- progLanguages
  } yield lng.toUpperCase)

  for (lng <- progLanguages) println(lng.toUpperCase)

  println(for (lng <- progLanguages) yield lng.toUpperCase)

  val progLanguages1 = List("java", "scala", "python")
  val lngAbbrev = List("JA", "SCA", "PY")
  val out = (lngAbbrev zip lngAbbrev)
  println(out)
  val sampleTuple = new Tuple2(2, "Hello, World")
  println(sampleTuple.copy(_2 = "Scala").swap._1 + 5)

  val someVal = Some(2)
  println(someVal.map(_ * 2))

  lazy  val x = { println("x"); 15 }
//  println(x)
}


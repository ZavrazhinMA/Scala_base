package part_1_variables.recursion

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(3)) // выводит 6

  def factorialWithTailRecursion(n: Int): Int = {
    @tailrec
    def loop(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else loop(x - 1, x * accumulator)
    }

    loop(n, 1)
  }

  print(factorialWithTailRecursion(3))

  def wordRepeat(word: String, n: Int): String = {
    @tailrec
    def loop(x: Int, acc_word: String = word): String = {
      if (x <= 1) acc_word
      else loop(x - 1, s"$word $acc_word")
    }
    loop(n)
  }

  println(wordRepeat("word", 3))

  def powerOfTwo(n: Int): BigInt = {
    @tailrec
    def loop(x: Int, base: BigInt = 2): BigInt = {
      if (x <= 1) base
      else loop(x - 1, base * 2)
    }
    loop(n)
  }

  println(powerOfTwo(10))


  def addValue(x: Int, y: Int, n: Int): BigInt = {
    @tailrec
    def loop(nn: Int, base: Int = x, yy: Int = y): BigInt = {
      if (nn <= 1) base + yy
      else loop(nn - 1, base + yy)
    }
    loop(n)
  }
  def digits(x: BigInt): Int = {
    x.toString().length
  }

  def print_res(mm: BigInt): String = {
    val n_n = digits(mm)
    @tailrec
    def loop1(nn: BigInt = digits(mm), base: String = mm.toString()): String = {
      println(nn)
      if (nn <= 1) s"$base"
      else loop1(nn - 1, s"$base ${mm.toString()}")
    }
    loop1(n_n)
  }
  println(s"${print_res(addValue(10, 1, 5))} is the result")

//  ==========================
  def reversword(input: String):String = {
    val slist = input.trim.split("\\s+").toList
    @tailrec
    def loop(nn: Int = slist.length, s_list: List[String] = slist, sbase: String = slist.last): String = {
      if (nn <= 1) sbase
      else loop(nn-1, s_list, sbase + " " + s_list(nn-2))
    }
    loop()
  }
  println(reversword(" I like      Scala"))
}

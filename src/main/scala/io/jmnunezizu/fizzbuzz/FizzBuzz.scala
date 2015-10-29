package io.jmnunezizu.fizzbuzz

class FizzBuzz {

  private val transformers = List(FizzT, BuzzT, BangT)

  def run(n: Int): String = {
    val result = transformers.flatMap(_.lift(n))
    if (result.isEmpty) n.toString
    else result.mkString
  }

}

abstract class NumberT(val value: String) extends PartialFunction[Int, String] {
  def apply(n: Int): String = value
}

case object FizzT extends NumberT("Fizz") {
  override def isDefinedAt(n: Int) = (n % 3) == 0
}

case object BuzzT extends NumberT("Buzz") {
  override def isDefinedAt(n: Int) = (n % 5) == 0
}

case object BangT extends NumberT("Bang") {
  override def isDefinedAt(n: Int) = (n % 7) == 0
}

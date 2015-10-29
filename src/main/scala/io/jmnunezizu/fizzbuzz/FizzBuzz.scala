package io.jmnunezizu.fizzbuzz

class FizzBuzz {

  private val transformers = List(FizzTransformer, BuzzTransformer, BangTransformer)

  def run(n: Int): String = {
    val pieces = for {
      transformer <- transformers
      result <- transformer(n)
    } yield result

    if (pieces.isEmpty) n.toString
    else pieces.mkString
  }

}

abstract class NumberTransformer(val value: String) extends ((Int) => Option[String]) {
  def apply(n: Int): Option[String] = if (eval(n)) Some(value) else None
  protected def eval(n: Int): Boolean
}

case object FizzTransformer extends NumberTransformer("Fizz") {
  override def eval(n: Int): Boolean = (n % 3) == 0
}

case object BuzzTransformer extends NumberTransformer("Buzz") {
  override def eval(n: Int): Boolean = (n % 5) == 0
}

case object BangTransformer extends NumberTransformer("Bang") {
  override def eval(n: Int): Boolean = (n % 7) == 0
}

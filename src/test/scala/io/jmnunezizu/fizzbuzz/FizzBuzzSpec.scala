package io.jmnunezizu.fizzbuzz

import org.specs2.Spec

class FizzBuzzSpec extends Spec {

  def is = s2"""
    fizzbuzz should
      return "Fizz" if the number is divisible by 3                     $e1
      return "Buzz" if the number is divisible by 5                     $e2
      return "FizzBuzz" if the number is divisible by 3 and 5           $e3
      return "Bang" if the number is divisible by 7                     $e4
      return "FizzBang" if the number is divisible by 3 and 7           $e5
      return "BuzzBang" if the number is divisible by 5 and 7           $e6
      return "FizzBuzzBang" if the number is divisible by 3, 5, and 7   $e7
      return the number if none of the above is true                    $e8
  """

  val underTest = new FizzBuzz()

  def e1 = underTest.run(3) must beEqualTo("Fizz")
  def e2 = underTest.run(5) must beEqualTo("Buzz")
  def e3 = underTest.run(15) must beEqualTo("FizzBuzz")
  def e4 = underTest.run(7) must beEqualTo("Bang")
  def e5 = underTest.run(21) must beEqualTo("FizzBang")
  def e6 = underTest.run(35) must beEqualTo("BuzzBang")
  def e7 = underTest.run(105) must beEqualTo("FizzBuzzBang")
  def e8 = underTest.run(1) must beEqualTo("1")

}

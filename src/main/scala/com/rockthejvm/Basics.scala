package com.rockthejvm

object Basics extends App {
  // defining a value
  val meaningOfLife: Int = 42

  // Common Data Types: Int, Boolean, Char, Double, Float, String
  // val aBoolean = False // type is optional

  // strings and strings operations
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions are structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  val chainedIfExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0
  }
  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // value of block is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  /*
    factorial(5) = 5 + factorial(4)
    factorial(4) = 4 + factorial(3)
    factorial(3) = 3 + factorial(2)
    factorial(2) = 2 + factorial(1)
    factorial(1) = 1
   */

  // In Scala don't use loops or iteration, RECURSION is used

  // the Unit type = no meaningful value === "void" in other languages
  // type of SIDE EFFECTS
  println("I love Scala")

  def myUnitReturningFunction(): Unit = {
   println("I don't like this")
  }

  val thisUnit = ()
}


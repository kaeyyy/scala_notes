package com.rockthejvm

object PatternMatching extends App{
  // swtich expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  // PM is an EXPRESSION

  // Case class decomposition
  case class Person(name: String, age: Int)
  val Bob = Person("Bob", 43) // Person.apply("Bob", 43)

  val personGreeting = Bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Something else"
  }

  // deconstructing tuple
  val aTuple = ("Bob Joyi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belonds to the genre $genre"
    case _ => "I don't know what you're talking about"
  }

  // decomposing lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "unknown list"
  }

  // if PM doesn't match anything, it will throw a MatchError
  // PM will try all cases in sequence i.e. case _ shld be the last

}

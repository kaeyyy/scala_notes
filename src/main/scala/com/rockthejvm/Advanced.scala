package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  /**
   * lazy evaluation
   */
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so busy")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1
  // lazy value is useful in infinite collections

  /**
   * pseudo-collection": Option, Try
   */
  def methodWhichCanReturnNull(): String = "hello, Scala"

  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, Scala")
  // option = "collection" which contains at most on element -> some("hello, Scala") or none

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  def methodWhichCanThrowException(): String = throw new RuntimeException

  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exception if the code throw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(ex) => s"I have obtained an exception: $ex"
  }

  /**
   * Evaluate something on another thread
   * asynchorous programming
   */
  val aFuture = Future {
    println("loading....")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  } // no need parentheis

  // future is a "collection" which contains a value when it is evaluated
  // future is composable with map, flatmap, filter

  /**
   * Implicits basics
   */

  // #1: implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  print(aMethodWithImplicitArgs)

  // #2: implicit conversion
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23,isEven()) // use implicits with care

}


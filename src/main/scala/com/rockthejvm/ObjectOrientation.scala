package com.rockthejvm

class ObjectOrientation extends App {

  // class and instance
  class Animal {
    // define fields
    val age: Int = 0
    def eat() = println("I am eating")
  }
  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal // constructor definition
  val aDog = new Dog("Lassic")

  // constructor arguments are NOT fields: need to put a val before the constructor arugment
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, can restrict by using private or protected
    // private val --> means only this class has access to this variable
    // protected val --> means this class and the dependencies have access to this variable
    def walk(): Unit
  }

  // "Interface" --> determine ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // single-class inheritance and multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal")

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with 1 argument
  aCroc ?! "What if we could fly!"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinasaur and i eat everything")
  }

  /*
   what you tell to compiler:

   class Carnivore_Anonymous extends Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinasaur and i eat everything")
   }

   val dinosaur = new Carnivore_Anonymous
   */

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 45234
    def mySpecialMethod(): Int = 5983
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  object Animal { // companions - companion object (same name)
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false

  }

  val animalCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
    case classes = lightweight data structure with some boiilerplate
    - sensible equlas and has code
    - serialization
    - companion with apply
    - pattern matching
   */
  case class Person(name: String, age: Int)

  // case classes can be constructed without new
  val bob = Person("Bob", 54) //Person.apply("Bob", 54)

  // exceptions
  
}

import demo.Hello
import week3.abstraction.{EmptySet, NonEmptySet}
import week3.lists.{Nil, Cons, List}
import scala.annotation.tailrec


val hello = new Hello
hello.sayHello("Scala")
hello.sayHello("Scala2")
val a = 1
def error(msg: String) = {
    throw new Exception(msg)
}

val xy: List[String] = Nil

//error("msg")

val x = null
val y: String = null

//val z = new Null

//val xy: Int = null
val list = new Cons[Integer](3, new Cons[Integer](5, new Cons[Integer](7, new Cons[Integer](9, Nil))))
list.nth(3)
def singleton[T](element: T) = new Cons[T](element, Nil)
singleton(1)
singleton(true)

def f(xs: List[NonEmptySet], x: EmptySet) = xs prepend x

val xzz = f(Nil, new EmptySet)

val xs = List(1, 2, 3)
val x1 = 4

val linked = x1 :: xs
xs.+:(x1)

val list1 = 1 :: 2 :: 3 :: 5 :: _root_.scala.Nil


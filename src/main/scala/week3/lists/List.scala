package week3.lists

/**
 * Created by Matija Vižintin
 * Date: 08. 07. 2015
 * Time: 20.58
 */
trait List[+T] {
    def isEmpty: Boolean

    def head: T

    def tail: List[T]

    def nth(n: Int): T

    def prepend[U >: T](element: U): List[U] = new Cons(element, this)
}

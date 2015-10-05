package week3.lists

/**
 * Created by Matija Vižintin
 * Date: 08. 07. 2015
 * Time: 20.58
 */
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    override def isEmpty: Boolean = false

    override def nth(n: Int): T = {
        if (n == 0) head
        else tail.nth(n - 1)
    }
}

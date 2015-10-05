package week3.lists

/**
 * Created by Matija Vižintin
 * Date: 08. 07. 2015
 * Time: 20.59
 */
object Nil extends List[Nothing] {
    override def isEmpty: Boolean = true

    override def tail: Nothing = throw new NoSuchElementException

    override def head: Nothing = throw new NoSuchElementException

    override def nth(n: Int): Nothing = throw new IndexOutOfBoundsException
}

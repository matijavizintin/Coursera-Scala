package week4

/**
 * Created by Matija Vižintin
 * Date: 23. 08. 2015
 * Time: 12.31
 */
abstract class Boolean {
    def ifThenElse[T](t: => T, e: => T): T

    def &&(x: => scala.Boolean): scala.Boolean = ifThenElse(x, false)

    def ||(x: => scala.Boolean): scala.Boolean = ifThenElse(true, x)
}

object True extends Boolean {
    override def ifThenElse[T](t: => T, e: => T): T = t
}

object False extends Boolean {
    override def ifThenElse[T](t: => T, e: => T): T = e
}
package week4

/**
 * Created by Matija Vižintin
 * Date: 23. 08. 2015
 * Time: 12.50
 */
abstract class Nat {
    def isZero: scala.Boolean

    def predecessor: Nat

    def successor: Nat

    def + (that: Nat): Nat

    def - (that: Nat): Nat
}

object Zero extends Nat {
    override def isZero: scala.Boolean = true

    override def successor: Nat = new Succ(this)

    override def +(that: Nat): Nat = that

    override def -(that: Nat): Nat = if (that.isZero) that else throw new Error

    override def predecessor: Nat = throw new Error
}

class Succ(n: Nat) extends Nat {
    override def isZero: scala.Boolean = false

    override def successor: Nat = new Succ(this)

    override def +(that: Nat): Nat = new Succ(n + that)

    override def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor

    override def predecessor: Nat = n
}

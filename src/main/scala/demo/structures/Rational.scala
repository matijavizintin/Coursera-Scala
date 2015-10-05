package demo.structures

/**
 * Created by Matija Vižintin
 * Date: 16. 06. 2015
 * Time: 21.22
 */
class Rational(x1: Int, y1: Int) {
    /**
     * predefined function - throws IllegalArgumentException
     *
     * is meant to enforce a precondition on the caller of a function
     *
     */
    require(y1 != 0, "Denomination must not be zero.")

    /**
     * predefined function - throws AssertionError
     *
     * used to check the code of the function itself
     */
    assert(true, "Assertion test error")

    val x = x1
    val y = y1

    /**
     * Second constructor other than the default with 2 parameters. The first constructor is the one defined in class parameters.
     *
     * @param x1    Int
     * @return      Rational(x1, 1)
     */
    def this(x1: Int) = this(x1, 1)

    private def add(that: Rational) = new Rational(this.x * that.y + that.x * this.y, this.y * that.y)

    def +(that: Rational) = add(that)

    private def sub(that: Rational) = this + -that

    def -(that: Rational) = sub(that)

    private def neg = new Rational(-this.x, this.y)

    /**
     * Prefix operator. Special case in scala. Now it can be used as -IDENTIFIER. If it was called just - it would be treated as infix operator and
     * -IDENTIFIER wouldn't be allowed.
     *
     * @return
     */
    def unary_- = neg

    private def less(that: Rational) = this.x * that.y < that.x * this.y

    def <(that: Rational) = less(that)

    def max(that: Rational) = if (this < that) that else this

    override def toString = x / gcd(x, y) + "/" + y / gcd(x, y)

    /**
     * cgd = Greatest Common divisor
     *
     * @param x     Int
     * @param y     Int
     * @return      Int
     */
    private def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
}



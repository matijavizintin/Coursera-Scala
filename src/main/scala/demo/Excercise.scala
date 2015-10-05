package demo

/**
 * Created by Matija Vižintin
 * Date: 15. 06. 2015
 * Time: 20.28
 */
object Excercise {

    def product(f: Int => Int)(a: Int, b: Int): Int = {
        if (a > b) 1 else f(a) * product(f)(a + 1, b)
    }

    def factorial(n: Int): Int = product(x => x)(1, n)

    def mapReduce(f: Int => Int, combiner: (Int, Int) => Int, unit: Int)(a: Int, b: Int): Int = {
        if (a > b) unit else combiner(f(a), mapReduce(f, combiner, unit)(a + 1, b))
    }


    def main(args: Array[String]) {
        val res = product(x => x)(1, 5)
        println(res)

        val fact = factorial(5)
        println(fact)

        val a1 = mapReduce(identity, (a, b) => a + b, 0)(1, 5)
        println(a1)

        val a2 = mapReduce(identity, (a, b) => a * b, 1)(1, 5)
        println(a2)
    }
}

object Excersise2 {
    import scala.math.abs

    val epsilon = 0.0001

    def isCloseEnough(x: Double, y: Double): Boolean = {
        abs(x - y) < epsilon
    }

    def fixedPoint(f: Double => Double)(guess: Double): Double = {
        val newY = f(guess)
        if (isCloseEnough(guess, newY)) guess
        else fixedPoint(f)(guess)
    }

    def sqrt(y: Double): Double = {
        fixedPoint(x => y / x)(1.0)
    }

    def avgDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

    def sqrt2(y: Double) = {
        fixedPoint(avgDamp(x => y / x))(1.0)
    }

    def main(args: Array[String]) {
//        val res = fixedPoint(x => 1 + (x / 2))(1)
//        println(res)

        val res2 = sqrt(2.0)
        println(res2)
    }
}

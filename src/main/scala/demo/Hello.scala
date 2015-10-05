package demo

import scala.annotation.tailrec

/**
 * Created by Matija Vižintin
 * Date: 11. 06. 2015
 * Time: 17.03
 */
class Hello {
    def sayHello(name: String) = s"Hello, $name!"
}

object SqrtObject {

    def sqrt(x: Double): Double = {

        def calcSqrt(guess: Double): Double =
            if (isGoodEnough(guess)) guess
            else calcSqrt(improve(guess))

        def isGoodEnough(guess: Double): Boolean =
            math.abs(guess * guess - x) < x * 1e-5

        def improve(guess: Double): Double =
            (guess + x / guess) / 2

        calcSqrt(1.0)
    }


}

object SqrtTest {
    def main(args: Array[String]) {
        println(SqrtObject.sqrt(2))
        println(SqrtObject.sqrt(1e-10))
        println(SqrtObject.sqrt(1e100))
        println(SqrtObject.sqrt(0.001))
        println(SqrtObject.sqrt(0.1e-20))
        println(SqrtObject.sqrt(1.0e20))
        println(SqrtObject.sqrt(1.0e50))
    }
}

object Sums {
    def sumInts(a: Int, b: Int): Int = sum(a => a, a, b)

    def sumCubes(a: Int, b: Int): Int = sum(a => a * a * a, a, b)

    def sumFact(a: Int, b: Int): Int = sum(fact, a, b)

    def sum(f: Int => Int, a: Int, b: Int): Int = {
        if (a > b) 0
        else f(a) + sum(f, a + 1, b)
    }

    def fact(a: Int): Int = {
        if (a == 0) 1 else a * fact(a - 1)
    }

    def sum2(f: Int => Int, a: Int, b: Int): Int = {
        @tailrec
        def loop(a: Int, acc: Int): Int = {
            if (a > b) acc
            else loop(a + 1, acc + f(a))
        }
        loop(a, 0)
    }

    def main(args: Array[String]) {
        println(sumInts(1, 6))

        println(sum2(fact, 1, 6))

        println(sumCubes(1,6))

        println(sumFact(1, 6))
    }
}

object Sums2 {
    import Sums.fact

    def sum(f: Int => Int): (Int, Int) => Int = {
        def sumFun(a: Int, b: Int): Int = {
            if (a > b) 0
            else f(a) + sumFun(a + 1, b)
        }
        sumFun
    }

    def sum1(f: Int => Int)(a: Int, b: Int): Int = {
        if (a > b) 0
        else f(a) + sum1(f)(a + 1, b)
    }

    def main(args: Array[String]) {
        println(sum(x => x)(1, 5))
        println(sum(x => x * x * x)(1, 5))
        println(sum(fact)(1, 5))
    }


}

package week6

import java.util.function.IntPredicate
import java.util.stream.IntStream

/**
 * Created by Matija Vižintin
 * Date: 12. 09. 2015
 * Time: 19.51
 */
object Ranges {
    def range() = {
        val r: Range = 1 to 5
        val s: Range = 1 until 5

        println(r)
        println(s)

        val rs: Range = 1 to 10 by 3
        val sr: Range = 6 to 1 by -2

        println(rs)
        println(sr)
    }

    def sequences() = {
        val xs = List(1, 2, 3, 4, 5, 6, 7, 8)

        val b = xs exists(x => x == 5)
        println(b)

        val b1 = xs forall(x => x < 10)
        println(b1)

        val ys = List(10, 11, 12, 13, 14, 15)

        val zipped = xs zip ys
        println(zipped)

        val (xs1, xs2): (List[Int], List[Int]) = zipped.unzip
        println(xs1)
        println(xs2)

        val flatten = xs flatMap(x => List(x, x))
        println(flatten)

        println(xs.sum)
        println(xs.product)
    }

    def combination() = {
        val M = 10
        val N = 15

        val res = (1 to M) flatMap(x => (1 to N) map(y => (x, y)))
        println(res)
    }

    def scalarProduct(xs: Vector[Int], ys: Vector[Int]) = {
        val res = (xs zip ys).map(x => x._1 * x._2).sum
        println(res)

        // short for match
        val res1 = (xs zip ys).map{case (x,y) => x * y}.sum
        println(res1)
    }

    def isPrime(n: Int): Boolean = {
        val b = (2 until n).forall(x => n % x != 0)
//        printf("%d is prime %s\n", n, b)
        b
    }

    def main(args: Array[String]) {
        range()
        sequences()
        combination()
        scalarProduct(Vector(1, 2, 3, 4), Vector(5, 6, 7))
        isPrime(13)
        isPrime(14)
    }
}

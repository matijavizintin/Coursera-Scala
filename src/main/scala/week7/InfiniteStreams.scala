package week7

import scala.language.postfixOps

/**
 * Created by Matija Vižintin
 * Date: 06. 10. 2015
 * Time: 20:51
 */
object InfiniteStreams {

    def main(args: Array[String]) {
        from(1).take(100).foreach(println)

        val list = from(0) map(_ * 2) take 20 toList

        println(list)

        val primes = sieve(from(2)) take 20 toList

        println(primes)

        squareStream(5).take(100).foreach(println)
    }

    def from(n: Int): Stream[Int] = n #:: from(n + 1)

    def sieve(s: Stream[Int]): Stream[Int] = {
        // take the first element in the stream, take the head, eliminate all multiples of head
        s.head #:: sieve(s.tail filter(x => x % s.head != 0))
    }

    def squareStream(x: Double): Stream[Double] = {
        def improve(guess: Double) = (guess + x / guess) / 2

        lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
        guesses
    }
}

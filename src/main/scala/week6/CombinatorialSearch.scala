package week6

/**
 * Created by Matija Vižintin
 * Date: 13. 09. 2015
 * Time: 17.34
 */
object CombinatorialSearch {
    def primeNumbersFromPairs(n: Int) = {
        (1 until n).flatMap(i => (1 until i).map(j => (i, j))).filter(x => Ranges.isPrime(x._1 + x._2))
    }

    def primeNumbersFromPairs1(n: Int) = {
        for {
            i <- 1 until n
            j <- 1 until i
            if Ranges.isPrime(i + j)
        } yield (i, j)
    }

    def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
        (for {
            (i, j) <- xs zip ys
        } yield i * j).sum
    }

    def main(args: Array[String]) {
        val primePairs = primeNumbersFromPairs(5)
        println(primePairs)

        val primePairs1 = primeNumbersFromPairs1(5)
        println(primePairs1)

        val scalarProduct1 = scalarProduct(List(1.0, 2.0, 3.0, 4.0), List(1.0, 10.0))
        println(scalarProduct1)
    }
}

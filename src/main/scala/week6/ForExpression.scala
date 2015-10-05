package week6

/**
 * Created by Matija Vižintin
 * Date: 19. 09. 2015
 * Time: 16.23
 */
object ForExpression {
    def mapFun[T, U](xs: List[T], f: T => U): List[U] = for (x <- xs) yield f(x)

    def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] = {
        for (x <- xs; y <- f(x)) yield y
    }

    def filter[T](xs: List[T], f: T => Boolean): List[T] = {
        for (x <- xs if f(x)) yield x
    }

    def forExpression(n: Int) = {
        for {
            i <- 1 until n
            j <- 1 until i
            if Ranges.isPrime(i + j)
        } yield (i, j)
    }

    def forTranslated(n: Int) = {
        (1 until n).flatMap(i => (1 until i).withFilter(j => Ranges.isPrime(i + j)).map(j => (i, j)))
    }

}

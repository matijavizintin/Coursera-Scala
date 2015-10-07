package week7

/**
 * Created by Matija Vižintin
 * Date: 05. 10. 2015
 * Time: 20:50
 */
object Streams {
    def main(args: Array[String]) {
        val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
        println(xs)

        val ys = (1 to 10000).toStream
        println(ys)

        performanceTest()
        performanceTest2()

        streamRange2(1, 10).take(3).toList
    }

    def streamRange2(lo: Int, hi: Int): Stream[Int] = {
        print(lo + " ")
        if (lo >= hi) Stream.empty
        else Stream.cons(lo, streamRange2(lo + 1, hi))
    }

    def performanceTest() = {
        val max = 1000000
        val start = System.currentTimeMillis()
        val stream = streamRange(1, max)
        val filteredStream = filterStream[Int](stream, x => x < 5)
        filteredStream.foreach(identity)
        val stop = System.currentTimeMillis()
        println("stream building time: " + (stop - start))

        val start1 = System.currentTimeMillis()
        val list = listRange(1, max)
        val filteredList = filterList[Int](list, x => x < 5)
        filteredList.foreach(identity)
        val stop1 = System.currentTimeMillis()
        println("list building time: " + (stop1 - start1))
    }

    def performanceTest2() = {
        val max = 1000000
        val start = System.currentTimeMillis()
        val stream = streamRange(1, max)
        val filteredStream = stream.take(5)
        filteredStream.foreach(identity)
        val stop = System.currentTimeMillis()
        println("stream building time: " + (stop - start))

        val start1 = System.currentTimeMillis()
        val list = listRange(1, max)
        val filteredList = list.take(5)
        filteredList.foreach(identity)
        val stop1 = System.currentTimeMillis()
        println("list building time: " + (stop1 - start1))
    }

    def streamRange(lo: Int, hi: Int): Stream[Int] = {
        if (lo >= hi) Stream.empty
        else Stream.cons(lo, streamRange(lo + 1, hi))
    }

    def listRange(lo: Int, hi: Int): List[Int] = {
        if (lo >= hi) Nil
        else lo :: listRange(lo + 1, hi)
    }

    def filterList[T](xs: List[T], p: T => Boolean): List[T] = {
        if (xs.isEmpty) xs
        else if (p(xs.head)) xs.head :: filterList(xs.tail, p)
        else filterList(xs.tail, p)
    }

    def filterStream[T](s: Stream[T], p: T => Boolean): Stream[T] = {
        if (s.isEmpty) s
        else if (p(s.head)) Stream.cons(s.head, filterStream(s.tail, p))
        else filterStream(s.tail, p)
    }
}

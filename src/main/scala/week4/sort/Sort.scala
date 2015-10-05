package week4.sort

import scala.annotation.tailrec
import scala.util.Random

/**
 * Created by Matija Vižintin
 * Date: 24. 08. 2015
 * Time: 19.34
 */
class Sort {

    def isort(xs: List[Int]): List[Int] = xs match {
        case List() => List()
        case y :: ys => insert(y, isort(ys))
    }

    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
        case List() => List(x)
        case y :: ys =>
            if (x <= y)
                x :: xs
            else
                y :: insert(x, ys)
    }

    def quickSort_tailRecursive(xs: Array[Int]) {
        def swap(i: Int, j: Int) {
            val t = xs(i);
            xs(i) = xs(j);
            xs(j) = t
        }
        def sortRange(l: Int, r: Int): (Int, Int) = {
            val pivot = xs((l + r) / 2)
            var i = l
            var j = r
            while (i <= j) {
                while (xs(i) < pivot) i += 1
                while (xs(j) > pivot) j -= 1
                if (i <= j) {
                    swap(i, j)
                    i += 1
                    j -= 1
                }
            }
            return (i, j)
        }
        @tailrec def sort2(segments: List[(Int, Int)]) {
            segments.head match {
                case (l, r) => {
                    var newSegments = segments.tail
                    sortRange(l, r) match {
                        case (i, j) => {
                            if (l < j) newSegments = (l, j) :: newSegments
                            if (i < r) newSegments = (i, r) :: newSegments
                        }
                    }
                    if (!newSegments.isEmpty) sort2(newSegments)
                }
            }
        }
        sort2(List((0, xs.length - 1)))
    }
}

object Test {

    def main(args: Array[String]) {
        val l = List.range(1, 1000 * 1000 * 10)
//        println(array)

        val start = System.currentTimeMillis()
        var l1 = Random.shuffle(l)
        new Sort().quickSort_tailRecursive(l1.toArray)
        val stop = System.currentTimeMillis()
        println(stop - start)
//        println(array.toList)
    }
}

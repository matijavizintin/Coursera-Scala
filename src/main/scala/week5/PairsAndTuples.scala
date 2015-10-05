package week5

import scala.annotation.tailrec

/**
 * Created by Matija Vižintin
 * Date: 03. 09. 2015
 * Time: 20.03
 */
object PairsAndTuples {

    def msort(xs: List[Int]): List[Int] = {
        val n = xs.length / 2
        if (n == 0) xs
        else {
            val (fst, snd) = xs splitAt n
            merge(msort(fst), msort(snd))
        }
    }

    private def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
        case Nil => ys
        case x :: xs1 =>
            ys match {
                case Nil => xs
                case y :: ys1 =>
                    if (x < y) x :: merge(xs1, ys)
                    else y :: merge(xs, ys1)
            }
    }

    def msort1(xs: List[Int]): List[Int] = {
        val n = xs.length / 2
        if (n == 0) xs
        else {
            val (fst, snd) = xs splitAt n
            merge1(msort1(fst), msort1(snd))
        }
    }

    private def merge1(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: _) if x < y => x :: merge1(xs1, ys)
        case (_, y :: ys1) => y :: merge1(xs, ys1)
    }
}

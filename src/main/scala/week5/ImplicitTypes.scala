package week5

/**
 * Created by Matija Vižintin
 * Date: 03. 09. 2015
 * Time: 20.37
 */
object ImplicitTypes {
    def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
        val n = xs.length / 2
        if (n == 0) xs
        else {
            val (fst, snd) = xs splitAt n
            merge(msort(fst)(lt), msort(snd)(lt), lt)
        }
    }

    private def merge[T](xs: List[T], ys: List[T], lt: (T, T) => Boolean): List[T] = (xs, ys) match {
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: _) if lt(x, y) => x :: merge(xs1, ys, lt)
        case (_, y :: ys1) => y :: merge(xs, ys1, lt)
    }

    def msort1[T](xs: List[T])(ord: Ordering[T]): List[T] = {
        val n = xs.length / 2
        if (n == 0) xs
        else {
            val (fst, snd) = xs splitAt n
            merge1(msort1(fst)(ord), msort1(snd)(ord), ord)
        }
    }

    private def merge1[T](xs: List[T], ys: List[T], ord: Ordering[T]): List[T] = (xs, ys) match {
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: _) if ord.lt(x, y) => x :: merge1(xs1, ys, ord)
        case (_, y :: ys1) => y :: merge1(xs, ys1, ord)
    }

    def msort2[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
        val n = xs.length / 2
        if (n == 0) xs
        else {
            val (fst, snd) = xs splitAt n
            merge2(msort2(fst), msort2(snd), ord)
        }
    }

    private def merge2[T](xs: List[T], ys: List[T], ord: Ordering[T]): List[T] = (xs, ys) match {
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: _) if ord.lt(x, y) => x :: merge2(xs1, ys, ord)
        case (_, y :: ys1) => y :: merge2(xs, ys1, ord)
    }
}

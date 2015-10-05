package week5

/**
 * Created by Matija Vižintin
 * Date: 02. 09. 2015
 * Time: 19.41
 */
object ListOperations {

    def last[T](xs: List[T]): T = xs match {
        // case of empty list
        case List() => throw new Error("Last on empty list")
        // case of only one element
        case List(x) => x
        // split head and tail
        case y :: ys => last(ys)
    }

    def init[T](xs: List[T]): List[T] = xs match {
        case List() => throw new Error("Init on empty list")
        case List(x) => List()
        case y :: ys => y :: init(ys)
    }

    def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
        case List() => ys
        case z :: zs => z :: concat(zs, ys)
    }

    def reverse[T](xs: List[T]): List[T] = xs match {
        case List() => List[T]()
        case y :: ys => reverse(ys) ++ List(y)
    }

    def removeAt[T](n: Int, xs: List[T]): List[T] = n match {
        case 0 => xs.tail
        case _ if xs.tail.isEmpty => xs
        case _ => xs.head :: removeAt(n - 1, xs.tail)
    }

    def removeAt1[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)

    def flatten(xs: List[Any]): List[Any] = xs match {
        case List() => List()
        case (y: List[_]) :: ys => flatten(y) ::: flatten(ys)
        case z :: zs => z :: flatten(zs)
    }
}

package week5

/**
 * Created by Matija Vižintin
 * Date: 04. 09. 2015
 * Time: 19.04
 */
object HighOrderFunctions {

    /**
     * This is a mapping function. It takes a list of type T and returns a list of type U. If uses a mapping function f: U => T
     *
     * @param xs            List[T]
     * @param f             T => U
     * @tparam T            input list type
     * @tparam U            output list type
     * @return              List[U]
     */
    def map[T, U](xs: List[T], f: T => U): List[U] = xs match {
        case Nil => List()
        case y :: ys => f(y) :: map(ys, f)
    }

    def squareList(xs: List[Int]): List[Int] = xs match {
        case Nil => List()
        case y :: ys => y * y :: squareList(ys)
    }

    def squareList1(xs: List[Int]): List[Int] = map(xs, (t: Int) => t * t)

    /**
     * This is a filter function. It takes a list of type T and filters it using function f. If filter accepts the element then T is mapped to true.
     *
     * @param xs            List[T]
     * @param f             T => Boolean
     * @tparam T            input list type
     * @return              List[T]
     */
    def filter[T](xs: List[T], f: T => Boolean): List[T] = xs match {
        case Nil => List()
        case y :: ys if f(y) => y :: filter(ys, f)
        case _ :: ys => filter(ys, f)
    }

    /**
     * This method creates a list of list that contains the same elements
     *
     * @param xs            List[T]
     * @tparam T            input list type
     * @return              List[ List[T] ]
     */
    def pack[T](xs: List[T]): List[List[T]] = xs match {
        case Nil => Nil
        case y :: ys =>
            val packed = pack(ys)
            packed match {
                case Nil => List(List(y))
                case z :: zs =>
                    if (z.head == y)  (y :: z) :: zs
                    else List(y) :: packed
            }
    }

    def pack1[T](xs: List[T]): List[List[T]] = xs match {
        case Nil => Nil
        case y :: ys =>
            val (take, drop) = xs span (x => x == y)
            take :: pack1(drop)
    }

    def encode[T](xs: List[T]): List[(T, Int)] = {
        xs.groupBy(x => x).mapValues(x => x.size).toList
    }

    def encode1[T](xs: List[T]): List[(T, Int)] = xs match {
        case Nil => Nil
        case y :: ys =>
            val (take, drop) = xs span (x => x == y)
            (y, take.size) :: encode1(drop)
    }

    def encode2[T](xs: List[T]): List[(T, Int)] =
        map(pack1(xs), (t: List[T]) => (t.head, t.size))
}

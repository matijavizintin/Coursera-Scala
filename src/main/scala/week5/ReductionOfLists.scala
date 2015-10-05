package week5

/**
 * Created by Matija Vižintin
 * Date: 10. 09. 2015
 * Time: 20.18
 */
object ReductionOfLists {

    /**
     * Normal sum function recursively going through the list
     *
     * @param xs        List[Int]
     * @return          Int
     */
    def sum(xs: List[Int]): Int = xs match {
        case Nil => 0
        case y :: ys => y + sum(ys)
    }

    /**
     * Normal reduce function recursively going through the list and applying the function.
     *
     * @param xs        List[Int]
     * @param f         (Int, Int) => Int
     * @return          Int
     */
    def reduce(xs: List[Int])(f: (Int, Int) => Int): Int = xs match {
        case Nil => throw new Error("Calling reduce on empty list.")
        case y :: Nil => y
        case y :: ys => f(y, reduce(ys)(f))
    }

    /**
     * Sum function using reduceLeft (x + y)
     *
     * @param xs
     * @return
     */
    def sum1(xs: List[Int]): Int = xs match {
        case Nil => throw new Error("Calling sum on empty list.")
        case _ => xs reduceLeft(_ + _)
    }

    /**
     * Reduce function using reduceLeft and applying the function f.
     *
     * @param xs
     * @param f
     * @return
     */
    def reduce1(xs: List[Int])(f: (Int, Int) => Int): Int = xs match {
        case Nil => throw new Error("Calling reduce on empty list.")
        case _ => xs reduceLeft f
    }

    /**
     * Sum function using foldLeft (0)(x + y)
     *
     * @param xs
     * @return
     */
    def sum2(xs: List[Int]): Int = xs match {
        case Nil => throw new Error("Calling sum on empty list.")
        case _ => (xs foldLeft 0)(_ + _)
    }

    /**
     * Reduce function using (ys foldLeft (y))(f)
     *
     * @param xs
     * @param f
     * @return
     */
    def reduce2(xs: List[Int])(f: (Int, Int) => Int): Int = xs match {
        case Nil => throw new Error("Calling reduce on empty list.")
        case y :: ys => (ys foldLeft y)(f)
    }

    def reduceRight[T](xs: List[T])(f: (T, T) => T): T = xs match {
        case Nil => throw new Error("Calling reduce on an empty list")
        case y :: ys => xs reduceRight f
    }

    def foldRight[T](xs: List[T])(f: (T, T) => T): T = xs match {
        case Nil => throw new Error("Calling fold on an empty list")
        case y :: ys => (ys foldRight y)(f)
    }

    def mapFun[T, U](xs: List[T], f: T => U): List[U] = (xs foldRight List[U]())((t, list) => f(t) :: list)

    def lengthFun[T](xs: List[T]): Int = (xs foldRight 0)((_, acc) => acc + 1)

    def mapFun1[T, U](xs: List[T], f: T => U): List[U] = (xs foldLeft List[U]())((list, t) => list :+ f(t))

    def lengthFun1[T](xs: List[T]): Int = (xs foldLeft  0)((acc, _) => acc + 1)
}

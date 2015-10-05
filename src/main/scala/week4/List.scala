package week4

import week3.abstraction.IntSet
import week3.lists.{Nil, Cons}

/**
 * Created by Matija Vižintin
 * Date: 23. 08. 2015
 * Time: 09.32
 */
object List {

    def apply[A](x1: A, x2: A): week3.lists.List[A] = {
        new Cons(x1, new Cons(x2, Nil))
    }

    def apply[A]() = Nil

    /**
     * S is subtype of IntSet --> defined by <:
     *
     * S :> T means that S is a supertype of T
     *
     * @param r
     * @tparam S
     * @return
     */
    def assertAllPos[S <: IntSet](r: S): S = ???
}

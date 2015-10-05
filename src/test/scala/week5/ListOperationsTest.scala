package week5

import org.scalatest.FunSuite

/**
 * Created by Matija Vižintin
 * Date: 02. 09. 2015
 * Time: 19.44
 */
class ListOperationsTest extends FunSuite {

    test("last element test") {
        val xs = List(1, 2, 3, 4, 5)
        val last = ListOperations.last(xs)

        assert(last === 5)
    }

    test("last on empty list") {
        intercept[Error] {
            ListOperations.last(List())
        }
    }

    test("init test") {
        val xs = List(1, 2, 3, 4, 5)
        val expected = List(1, 2, 3, 4)

        assert(ListOperations.init(xs) === expected)
    }

    test("init on single element") {
        val xs = List(1)
        val expected = List()

        assert(ListOperations.init(xs) == expected)
    }

    test("init on empty list") {
        intercept[Error] {
            ListOperations.init(List())
        }
    }

    test("concat test") {
        val xs = List(1, 2, 3)
        val ys = List(4, 5, 6)
        val expected = List(1, 2, 3, 4, 5, 6)

        assert(expected === ListOperations.concat(xs, ys))
    }

    test("concat on empty list") {
        val xs = List(1, 2, 3)
        val ys = List()

        assert(xs === ListOperations.concat(xs, ys))
        assert(xs === ListOperations.concat(ys, xs))
    }

    test("concat on two empty lists") {
        assert(List() === ListOperations.concat(List(), List()))
    }

    test("reverse test") {
        val xs = List(1, 2, 3, 4, 5)
        val expected = List(5, 4, 3, 2, 1)

        assert(ListOperations.reverse(xs) === expected)
    }

    test("reverse on empty") {
        assert(ListOperations.reverse(List()) == List())
    }

    test("remove at 0 test") {
        val xs = List(1, 2, 3, 4, 5)
        val n = 0
        val expect = List(2, 3, 4, 5)

        assert(ListOperations.removeAt(n, xs) === expect)
    }

    test("remove at 2 test") {
        val xs = List(1, 2, 3, 4, 5)
        val n = 2
        val expect = List(1, 2, 4, 5)

        assert(ListOperations.removeAt(n, xs) === expect)
    }

    test("remove at index out of bounds test") {
        val xs = List(1, 2, 3, 4, 5)
        val n = 5
        val expect = List(1, 2, 3, 4, 5)

        assert(ListOperations.removeAt(n, xs) === expect)
    }

    test("remove at -1 test") {
        val xs = List(1, 2, 3, 4, 5)
        val n = -1
        val expect = List(1, 2, 3, 4, 5)

        assert(ListOperations.removeAt(n, xs) === expect)
    }

    test("remove1 at 0 test") {
        val xs = List(1, 2, 3, 4, 5)
        val n = 0
        val expect = List(2, 3, 4, 5)

        assert(ListOperations.removeAt1(n, xs) === expect)
    }

    test("remove1 at 2 test") {
        val xs = List(1, 2, 3, 4, 5)
        val n = 2
        val expect = List(1, 2, 4, 5)

        assert(ListOperations.removeAt1(n, xs) === expect)
    }

    test("remove1 at index out of bounds test") {
        val xs = List(1, 2, 3, 4, 5)
        val n = 5
        val expect = List(1, 2, 3, 4, 5)

        assert(ListOperations.removeAt1(n, xs) === expect)
    }

    test("remove1 at -1 test") {
        val xs = List(1, 2, 3, 4, 5)
        val n = -1
        val expect = List(1, 2, 3, 4, 5)

        assert(ListOperations.removeAt1(n, xs) === expect)
    }

    test("flatten test") {
        val xs = List(List(1, 2, 3), 1, 2, List(3))
        val expected = List(1, 2, 3, 1, 2, 3)

        assert(ListOperations.flatten(xs) === expected)
    }

    test("flatten test 2") {
        val xs = List(1, List(1, 2, 3), 1, 2, List(3), 1)
        val expected = List(1, 1, 2, 3, 1, 2, 3, 1)

        assert(ListOperations.flatten(xs) === expected)
    }

    test("flatten with empty") {
        val xs = List(List(), List(1, 2, 3), List(), 1, 2, List(3), 1)
        val expected = List(1, 2, 3, 1, 2, 3, 1)

        assert(ListOperations.flatten(xs) === expected)
    }

    test("flatten on empty") {
        val xs = List()
        val expected = List()

        assert(ListOperations.flatten(xs) === expected)
    }

    test("flatten with Nil") {
        val xs = List(Nil, List(1, 2, 3), List(), Nil, 2, List(3), 1)
        val expected = List(1, 2, 3, 2, 3, 1)

        assert(ListOperations.flatten(xs) === expected)
    }
}

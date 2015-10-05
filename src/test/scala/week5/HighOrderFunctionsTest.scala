package week5

import org.scalatest.FunSuite
import HighOrderFunctions._
import org.scalatest.exceptions.TestFailedException

/**
 * Created by Matija Vižintin
 * Date: 04. 09. 2015
 * Time: 19.08
 */
class HighOrderFunctionsTest extends FunSuite {

    test("test on ints") {
        val input = List(1, 2, 3, 4, 5)
        val output = List(2, 4, 6, 8, 10)

        assert(map(input, (t: Int) => 2 * t) === output)
    }

    test("test on strings") {
        val input = List("abc", "def", "ghi")
        val output = List("ABC", "DEF", "GHI")

        assert(map(input, (t: String) => t.toUpperCase) === output)
    }

    test("test square lists") {
        val input = List(1, 2, 3, 4, 5)
        val output = List(1, 4, 9, 16, 25)

        assert(squareList(input) === output)
        assert(squareList1(input) === output)
    }

    test("filter") {
        val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val output = List(5, 6, 7, 8, 9)

        assert(filter(input, (t: Int) => t > 4) === output)
    }

    test("pack") {
        val input = List("a", "a", "a", "b", "c", "c", "a")
        val output = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))

        assert(pack(input) == output)
    }

    test("pack empty") {
        assert(pack(List()) == List())
    }

    test("pack1") {
        val input = List("a", "a", "a", "b", "c", "c", "a")
        val output = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))

        assert(pack1(input) == output)
    }

    test("pack1 empty") {
        assert(pack1(List()) == List())
    }

    test("encode test") {
        val input = List("a", "a", "a", "b", "c", "c", "a")
        val output = List(("a", 3), ("b", 1), ("c", 2), ("a", 1))

        intercept[TestFailedException] {
            assert(encode(input) === output)
        }
    }

    test("encode empty") {
        assert(encode(List()) == List())
    }

    test("encode1 test") {
        val input = List("a", "a", "a", "b", "c", "c", "a")
        val output = List(("a", 3), ("b", 1), ("c", 2), ("a", 1))

        assert(encode1(input) === output)
    }

    test("encode1 empty") {
        assert(encode1(List()) == List())
    }

    test("encode2 test") {
        val input = List("a", "a", "a", "b", "c", "c", "a")
        val output = List(("a", 3), ("b", 1), ("c", 2), ("a", 1))

        assert(encode2(input) === output)
    }

    test("encode2 empty") {
        assert(encode2(List()) == List())
    }
}

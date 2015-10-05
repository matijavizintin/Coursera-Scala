package week5

import org.scalatest.FunSuite
import PairsAndTuples._

/**
 * Created by Matija Vižintin
 * Date: 03. 09. 2015
 * Time: 20.17
 */
class PairsAndTuplesTest extends FunSuite {

    trait TestData {
        val input = List(2, 3, 5, 1, 8, 7, 4, 6)
        val expected = List(1, 2, 3, 4, 5, 6, 7, 8)
    }

    test("test first sort") {
        new TestData {
            assert(msort(input) === expected)
        }
    }

    test("test second sort") {
        new TestData {
            assert(msort1(input) === expected)
        }
    }

    test("test empty on first") {
        assert(msort(List()) == List())
    }

    test("test empty on second") {
        assert(msort1(List()) == List())
    }

    test("test one element on first") {
        assert(msort(List(5)) == List(5))
    }

    test("test one element on second") {
        assert(msort1(List(5)) == List(5))
    }

}

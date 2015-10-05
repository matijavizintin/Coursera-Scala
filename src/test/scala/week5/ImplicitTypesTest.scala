package week5

import org.scalatest.FunSuite
import org.scalatest.exceptions.TestFailedException
import week5.ImplicitTypes._

/**
 * Created by Matija Vižintin
 * Date: 03. 09. 2015
 * Time: 20.40
 */
class ImplicitTypesTest extends FunSuite {
    case class WrapperTest(n: Int)

    trait TestData {
        val inputString = List("b", "f", "d", "c", "e", "a")
        val expectedString = List("a", "b", "c", "d", "e", "f")

        val inputWrapped = List(WrapperTest(5), WrapperTest(2), WrapperTest(3), WrapperTest(1), WrapperTest(4))
        val expectedWrapped = List(WrapperTest(1), WrapperTest(2), WrapperTest(3), WrapperTest(4), WrapperTest(5))
    }

    test("test strings") {
        new TestData {
            assert(msort(inputString)((a, b) => a < b) === expectedString)
        }
    }

    test("test wrapped") {
        new TestData {
            assert(msort(inputWrapped)((a, b) => a.n < b.n) === expectedWrapped)
        }
    }

    test("test on empty") {
        assert(msort(List())((_, _) => false) === List())
    }

    test("test without compare function") {
        intercept[TestFailedException] {
            assert(msort(List()) _ === List())
        }
    }

    test("test strings with ord") {
        new TestData {
            assert(msort1(inputString)(Ordering.String) === expectedString)
        }
    }

    test("test strings with implicit ord") {
        new TestData {
            assert(msort2(inputString) === expectedString)
        }
    }
}

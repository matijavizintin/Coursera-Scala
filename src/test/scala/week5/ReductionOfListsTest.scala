package week5

import org.scalatest.FunSuite
import ReductionOfLists._

/**
 * Created by Matija Vižintin
 * Date: 10. 09. 2015
 * Time: 20.18
 */
class ReductionOfListsTest extends FunSuite {
    trait TestData {
        val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val inputSmall = List(1, 2, 3, 4)
    }

    test("sum test") {
        new TestData {
            assert(55 === sum(input))
        }
    }

    test("reduce with sum") {
        new TestData {
            assert(55 == reduce(input)(_ + _))
        }
    }

    test("reduce with product") {
        new TestData {
            assert(24 == reduce(inputSmall)(_ * _))
        }
    }

    test("reduceLeft sum") {
        new TestData {
            assert(55 == sum1(input))
        }
    }

    test("reduceLest product") {
        new TestData {
            assert(24 == reduce1(inputSmall)(_ * _))
        }
    }

    test("fold left sum") {
        new TestData {
            assert(55 == sum2(input))
        }
    }

    test("fold left product") {
        new TestData {
            assert(24 == reduce2(inputSmall)(_ * _))
        }
    }

    test("fold right sum") {
        new TestData {
            assert(55 == foldRight(input)(_ + _))
        }
    }

    test("reduce right product") {
        new TestData {
            assert(24 == reduceRight(inputSmall)(_ * _))
        }
    }

    test("mapFun test") {
        new TestData {
            val expected = List(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
            assert(expected === mapFun(input, (x: Int) => x + 1))
        }
    }

    test("lengthFun test") {
        new TestData {
            assert(10 === lengthFun(input))
        }
    }

    test("mapFun1 test") {
        new TestData {
            val expected = List(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
            assert(expected === mapFun1(input, (x: Int) => x + 1))
        }
    }

    test("lengthFun1 test") {
        new TestData {
            assert(10 === lengthFun1(input))
        }
    }
}

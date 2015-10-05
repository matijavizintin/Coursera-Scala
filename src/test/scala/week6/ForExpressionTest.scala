package week6

import org.scalatest.FunSuite
import ForExpression._

/**
 * Created by Matija Vižintin
 * Date: 19. 09. 2015
 * Time: 16.34
 */
class ForExpressionTest extends FunSuite {

    test("mapFun test") {
        val input = List(1, 2, 3, 4)
        val output = mapFun(input, (x: Int) => x + 1)
        val expected = List(2, 3, 4, 5)

        assert(expected === output)
    }

    test("flatMap test") {
        val input = List(List(1), List(2), List(3), List(4, 5))
        val flat = flatMap(input, (x: List[Int]) => x)
        val expected = List(1, 2, 3, 4, 5)

        assert(expected === flat)
    }

    test("filter test") {
        val input = List(1, 2, 3, 4, 5)
        val filtered = filter(input, (x: Int) => x < 3)
        val expected = List(1, 2)

        assert(expected === filtered)
    }

    test("for translated") {
        val input = forExpression(10)
        val expected = forTranslated(10)

        assert(input === expected)
    }
}


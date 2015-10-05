package week6

import org.scalatest.FunSuite

/**
 * Created by Matija Vižintin
 * Date: 19. 09. 2015
 * Time: 20.06
 */
class MapsTest extends FunSuite {

    trait TestData {
        val map = Map("I" -> 1, "V" -> 5, "X" -> 10)
    }

    test("map as function with existing key") {
        new TestData {
            assert(1 === map("I"))

            assert(Some(1) === (map get "I"))
        }
    }

    test("map as function with non existing key") {
        new TestData {
            intercept[NoSuchElementException] {
                map("M")
            }

            val expected = None
            assert(expected === map.get("M"))
        }
    }

    test("map as total function") {
        new TestData {
            val totalMap = map withDefaultValue -1

            assert(-1 === totalMap("M"))
        }
    }
}

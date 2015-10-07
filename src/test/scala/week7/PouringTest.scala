package week7

import org.scalatest.FunSuite
import week7.waterpouring.Pouring

/**
 * Created by Matija Vižintin
 * Date: 07. 10. 2015
 * Time: 20:17
 */
class PouringTest extends FunSuite {
    test("simple") {
        val p = new Pouring(Vector(4, 9, 19, 5, 6, 12, 3, 15))

        println("\nall possible")
//        p.pathSets.take(3).foreach(println)

        println("\nsolutions")
        p.solutions(14).take(3).foreach(println)
    }
}

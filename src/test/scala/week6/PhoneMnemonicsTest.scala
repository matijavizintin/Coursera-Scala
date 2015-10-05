package week6

import org.scalatest.FunSuite
import PhoneMnemonics._

/**
 * Created by Matija Vižintin
 * Date: 20. 09. 2015
 * Time: 11.52
 */
class PhoneMnemonicsTest extends FunSuite {

    test("test encode") {
        val encoded = encode("7225247386")

        println(encoded)
    }

    test("test translate") {
        val t = translate("7225247386")

        println(t)
    }
}

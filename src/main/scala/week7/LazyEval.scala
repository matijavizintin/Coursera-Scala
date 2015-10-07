package week7

/**
 * Created by Matija Vižintin
 * Date: 06. 10. 2015
 * Time: 20:16
 */
object LazyEval {
    def main(args: Array[String]) {
        expr
    }

    def expr = {
        val x = {
            print("x"); 1
        }

        lazy val y = {
            print("y"); 2
        }

        def z = {
            print("z"); 3
        }

        z + y + x + z + y + x
    }
}

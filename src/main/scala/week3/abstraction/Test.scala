package week3.abstraction

/**
 * Created by Matija Vižintin
 * Date: 08. 07. 2015
 * Time: 19.46
 */
object Test {
    def main(args: Array[String]) {
        val s1 = new NonEmptySet(10, new NonEmptySet(5), new NonEmptySet(12))
        val s2 = new NonEmptySet(5, new NonEmptySet(1), new NonEmptySet(15))

        val s3 = s1 union s2
        println("\nResult: " + s3)
    }
}

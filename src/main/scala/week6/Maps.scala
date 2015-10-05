package week6

/**
 * Created by Matija Vižintin
 * Date: 19. 09. 2015
 * Time: 20.00
 */
object Maps {
    def main(args: Array[String]) {
        val map = Map("I" -> 1, "V" -> 5, "X" -> 10)

        println(map)

        // group by
        val list = List("apple", "pineapple", "peach", "pear", "banana")
        val  mapped = list groupBy(_.head)

        println(mapped)

        // polynomial
        val first = new Polynomial(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
        val second = new Polynomial(0 -> 3.0, 3 -> 7)

        val summed = first + second
        println(first)
        println(second)
        println(summed)

        println()
        val summed1 = first plus second
        println(first)
        println(second)
        println(summed1)
    }

    class Polynomial(val terms0: Map[Int, Double]) {
        val terms = terms0 withDefaultValue 0.0

        def this(bindings: (Int, Double)*) = this(bindings.toMap)

        def +(other: Polynomial) = {
            new Polynomial(terms ++ (other.terms map adjust))
        }

        def plus(other: Polynomial) = {
            new Polynomial((other.terms foldLeft terms)(addTerm))
        }

        def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
            val (exp, coeff) = term
            terms + (exp -> (coeff + terms(exp)))
        }

        private def adjust(term: (Int, Double)): (Int, Double) = {
            val (exp, coeff) = term
            exp -> (coeff + terms(exp))
        }

        override def toString = {
            (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp).mkString(" + ")
        }
    }
}

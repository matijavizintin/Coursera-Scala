package week6

/**
 * Created by Matija Vižintin
 * Date: 13. 09. 2015
 * Time: 19.32
 */
object NQueens {

    def solve(n: Int): Set[List[Int]] = {
        def placeQueens(k: Int): Set[List[Int]] = {
            if (k == 0) Set(List())
            else
                for {
                    queens <- placeQueens(k - 1)
                    col <- 0 until n
                    if isSafe(col, queens)
                } yield col :: queens
        }
        placeQueens(n)
    }

    def isSafe(col: Int, queens: List[Int]): Boolean = {
        val row = queens.length
        val rowCol = (row - 1 to 0 by -1) zip queens

        rowCol forall {
            case (r, c) => c != col && math.abs(col - c) != row - r
        }
    }

    def show(queens: List[Int]) = {
        val lines = for (col <- queens.reverse) yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
        println("\n" + (lines mkString "\n"))
    }

    def main(args: Array[String]) {
        val start = System.currentTimeMillis()
        val res = solve(13)
        val stop = System.currentTimeMillis()
        println(stop - start)

        println("Size: " + res.size)
//        res foreach show
    }


}

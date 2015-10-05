package week4.expr

/**
 * Created by Matija Vižintin
 * Date: 23. 08. 2015
 * Time: 17.24
 */
trait Expr1 {
    def eval: Int = this match {
        case Number1(n) => n
        case Sum1(left, right) => left.eval + right.eval
    }

    def show: String = this match {
        case Number1(n) => n.toString
        case Sum1(left, right) => left.show + " + " + right.show
    }
}

case class Number1(n: Int) extends Expr1 {

}

case class Sum1(left: Expr1, right: Expr1) extends Expr1 {
    
}

object Abc {
    Number1(5)
}

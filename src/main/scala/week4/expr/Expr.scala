package week4.expr

/**
 * Created by Matija Vižintin
 * Date: 23. 08. 2015
 * Time: 17.03
 */
trait Expr {
    def eval: Int
}

class Number(n: Int) extends Expr{
    override def eval: Int = n
}

class Sum(left: Expr, right: Expr) extends Expr {
    override def eval: Int = left.eval + right.eval
}

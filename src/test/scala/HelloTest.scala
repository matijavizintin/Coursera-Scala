import demo.Hello
import org.scalatest.FunSuite

/**
 * Created by Matija Vižintin
 * Date: 11. 06. 2015
 * Time: 17.12
 */
class HelloTest extends FunSuite {
    test("Ssy hello method work correctly") {
        val hello = new Hello
        assert(hello.sayHello("Scala") == "Hello, Scala!")
    }
}

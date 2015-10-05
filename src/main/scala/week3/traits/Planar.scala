package week3.traits

/**
 * Created by Matija Vižintin
 * Date: 08. 07. 2015
 * Time: 20.27
 */
trait Planar {
    def width: Int

    def height: Int

    def surface = width * height
}

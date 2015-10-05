package week3.abstraction

/**
 * Created by Matija Vižintin
 * Date: 08. 07. 2015
 * Time: 18.16
 */
abstract class IntSet {
    def incl(x: Int): IntSet

    def contains(x: Int): Boolean

    def union(other: IntSet): IntSet
}

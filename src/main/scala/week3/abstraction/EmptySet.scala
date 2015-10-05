package week3.abstraction

/**
 * Created by Matija Vižintin
 * Date: 08. 07. 2015
 * Time: 18.29
 */
// singleton object
class EmptySet extends IntSet {
    def incl(x: Int): IntSet = new NonEmptySet(x, new EmptySet, new EmptySet)

    def contains(x: Int): Boolean = false

    def union(other: IntSet): IntSet = {
        printf("Other: %s\n", other)
        other
    }

    override def toString = "."
}

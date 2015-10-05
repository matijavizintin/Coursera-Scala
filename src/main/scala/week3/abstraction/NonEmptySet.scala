package week3.abstraction

/**
 * Created by Matija Vižintin
 * Date: 08. 07. 2015
 * Time: 18.30
 */
class NonEmptySet(element: Int, left: IntSet, right: IntSet) extends IntSet {
    // additional constructor
    def this(element: Int) {
        this(element, new EmptySet, new EmptySet)
    }

    def incl(x: Int): IntSet = {
        // NOTE: when adding an element to the tree make a copy so the structure remain immutable
        if (x < element) new NonEmptySet(element, left incl x, right)
        else if (x > element) new NonEmptySet(element, left, right incl x)
        else this
    }

    def contains(x: Int): Boolean = {
        if (x < element) left contains x
        else if (x > element) right contains x
        else true
    }

    def union(other: IntSet): IntSet = {
        printf("Left %s, right %s, other: %s, element: %s\n", left, right, other, element)
        left union right union other incl element
    }

    override def toString = "{" + left + element + right + "}"


}

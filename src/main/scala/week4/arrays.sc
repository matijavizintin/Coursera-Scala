import week3.abstraction.{IntSet, EmptySet, NonEmptySet}

val a: Array[NonEmptySet] = Array(new NonEmptySet(1))
val b: Array[IntSet] = a
b(0) = EmptySet
val s: NonEmptySet = a(0)


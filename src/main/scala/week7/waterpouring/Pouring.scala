package week7.waterpouring

/**
 * Created by Matija Vižintin
 * Date: 07. 10. 2015
 * Time: 19:21
 */
class Pouring(capacity: Vector[Int]) {
    type State = Vector[Int]

    val initialState = capacity map (x => 0)
    val initialPath = new Path(Nil, initialState)
    val glasses = capacity.indices

    val moves =
        (for (g <- glasses) yield Empty(g)) ++
        (for (g <- glasses) yield Full(g)) ++
        (for (f <- glasses; t <- glasses; if f != t) yield Pour(f, t))

    def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] = {
        if (paths.isEmpty) Stream.empty
        else {
            val nextPaths = for {
                path <- paths
                next <- moves map path.extend
                if !(explored contains next.endState)
            } yield next

            paths #:: from(nextPaths, explored ++ (nextPaths map(_.endState)))
        }
    }

    val pathSets = from(Set(initialPath), Set(initialState))

    def solutions(target: Int): Stream[Path] = {
        for {
            paths <- pathSets
            path <- paths
            if path.endState contains target
        } yield path
    }

    // paths
    class Path(history: List[Move], val endState: State) {
//        lazy val endState: State = (history foldRight initialState)((move, state) => move change state)

        def extend(move: Move) = new Path(move :: history, move change endState)

        override def toString = (history.reverse mkString " ") + " --> " + endState
    }

    // moves
    trait Move {
        def change(state: State): State
    }

    case class Empty(glass: Int) extends Move {
        override def change(state: State): State = state.updated(glass, 0)
    }

    case class Full(glass: Int) extends Move {
        override def change(state: State): State = state.updated(glass, capacity(glass))
    }

    case class Pour(from: Int, to: Int) extends Move {
        override def change(state: State): State = {
            val amount = state(from) min (capacity(to) - state(to))
            state.updated(from, state(from) - amount).updated(to, state(to) + amount)
        }
    }
}

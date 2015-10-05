package week6

import scala.io.Source

/**
 * Created by Matija Vižintin
 * Date: 20. 09. 2015
 * Time: 10.57
 */
object PhoneMnemonics {
    val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
    val words = in.getLines().toList filter (word => word forall (c => c.isLetter))

    val mnemonics = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

    // maps letters to digits; eg. '2' -> 'A', '2' -> 'B', etc.
    val charCode: Map[Char, Char] = {
        for {
            (digit, string) <- mnemonics
            letter <- string
        } yield letter -> digit
    }

    // maps strings to letters eg. "Java" -> "5282"
    def wordCode(word: String): String = word.toUpperCase map charCode

    // map from digits to words that represent them eg. "5282" -> List("Java", "Lava", "Kata", ...)
    val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode withDefaultValue Seq()


    def encode(phoneNumber: String): Set[List[String]] = {
        if (phoneNumber.isEmpty) Set(List())
        else {
            (for {
                split <- 1 to phoneNumber.length
                word <- wordsForNum(phoneNumber take split)
                other <- encode(phoneNumber drop split)
            } yield word :: other).toSet
        }
    }

    def translate(phoneNumber: String): Set[String] = encode(phoneNumber) map(_ mkString " ")
}

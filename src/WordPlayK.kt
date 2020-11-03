import java.io.File
import java.lang.StringBuilder

fun readFile(name : String) = File(name).readLines()

fun countChars(list : List<String>) : Int {
    var sum = 0
    for (word in list) sum += word.length;
    return sum
}

fun countEachChar(list: List<String>): HashMap<Char, Int?> {
    val amountEachChar = HashMap<Char, Int?>()

    for (word in list)
        for (char in word) {
            if (char in amountEachChar) {
                amountEachChar[char] = amountEachChar[char]?.plus(1)
            } else amountEachChar[char] = 1
        }

    return amountEachChar
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)
infix fun Int.fdiv(i: Int): Double = this / i.toDouble();

fun main() {
    val name = "Words.txt"
    val fileContent : List<String> = readFile("src/$name")

    val amountOfWords = fileContent.size
    val amountOfChars = countChars(fileContent)
    val charCounts = countEachChar(fileContent)
    val avgWordLength = amountOfChars/amountOfWords

    val stats = StringBuilder()

    stats.append("The $name file has been analyzed and below there will be some analytics listed.\n\n")
    stats.append("The file has $amountOfWords words and $amountOfChars characters. The words in" +
            "the file have an average length of $avgWordLength\n\nThis is the percent make up of each " +
            "character in the file:\n")

    for ((k, v) in charCounts) {
        stats.append("$k | ${(v?.fdiv(amountOfChars))?.format(2)}% \n")
    }


    File("stats.txt").writeText(stats.toString())
}

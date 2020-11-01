import java.lang.StringBuilder

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    if (secret == guess) return Evaluation(secret.length, 0)

    var rightPosition = 0
    var wrongPosition = 0

    val listToBeDeleted = mutableListOf<Int>()
    for (i in secret.indices) {
        if (secret[i] == guess[i]){
            rightPosition++
            listToBeDeleted.add(i)
        }
    }

    val sbSecret = StringBuilder(secret)
    val sbGuess = StringBuilder(guess)

    for (i in listToBeDeleted.indices) {
        val del = listToBeDeleted[i] - i
        sbSecret.deleteCharAt(del)
        sbGuess.deleteCharAt(del)
    }

    for (i in sbGuess.indices) {
        if(sbGuess[i] in sbSecret) {
            wrongPosition++
            sbSecret.deleteCharAt(sbSecret.indexOf(sbGuess[i]))
        }
    }

    return Evaluation(rightPosition, wrongPosition);
}

fun main() {
    val eval = evaluateGuess("appbjlkl", "appslbkl")
    println("The evaluation of the string resulted in ${eval.rightPosition} right positions and ${eval.wrongPosition} and wrong positions")
}
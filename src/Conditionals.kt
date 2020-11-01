
fun main() {
    println("Please input a number for me to analyze :) ")
    val num = readLine()?.toInt()

    if (num != null) {
        when {
            num < 10 -> println("$num is less than ten")
            num < 25 -> println("$num is lest then twenty-five but more than ten")
            else -> println("$num is a number bigger than twenty-five")
        }
    }

}
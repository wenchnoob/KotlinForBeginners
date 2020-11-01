fun main() {
    val a = 3
    val b = 5
    println("The sum of $a, $b is ${add(a,b)}")
}

fun add(a : Int = 0, b: Int = 0) : Int {
    return a + b
}
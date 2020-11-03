import java.io.File

// One method to write to files is using the writeText function in the file class.
fun helloWorld() = File("HelloWorld.txt").writeText("Hello World")

// Another method using a printWriter object and a lambda function.
fun helloWorld2() = File("HelloWorld.txt").printWriter().use { out -> out.println("Hello World 2") }

fun main() {
    // Both functions operate as expected.
    helloWorld()
    helloWorld2()
}
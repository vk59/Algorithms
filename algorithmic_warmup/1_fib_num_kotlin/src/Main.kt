import java.util.*

fun calcFib(n: Long): Long {
    if (n == 0L) {
        return 0
    }
    var a = 0L
    var b = 1L
    var c: Long
    for (i in 2..n){
        c = a + b
        a = b
        b = c
    }
    return b
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()

    println(calcFib(n))
}
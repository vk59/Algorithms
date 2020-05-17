import java.util.*

fun getChange(m: Int): Int {
    val mas = IntArray(m + 1, {0})
    val coins = arrayOf(1, 3, 4)
    mas[0] = 0
    for (i in 1..m) {
        var minMv = 10000000
        for (coin: Int in coins) {
            if (coin <= i) {
                if (mas[i - coin] < minMv) {
                    minMv = mas[i - coin]
                }
            }
        }
        mas[i] += minMv + 1
    }
    return mas[m]
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val m = scanner.nextInt()
    println(getChange(m))
}

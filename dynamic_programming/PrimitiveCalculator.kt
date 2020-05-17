import java.util.*

fun optimalSequence(n: Int): List<Int> {
    val sequence = ArrayList<Int>()
    val a = IntArray(n + 1, {0})
    a[1] = 0
    for (i in 2..n) {
        a[i] = a[i - 1] + 1
        if ((i % 2 == 0) && (a[i / 2] + 1 < a[i])) {
            a[i] = a[i / 2] + 1
        }
        if (i % 3 == 0 && (a[i / 3] + 1 < a[i])) {
            a[i] = a[i / 3] + 1
        }
    }
    var minA = a[n] + 1
    for (i in n downTo 0) {
        if (a[i] < minA) {
            minA = a[i]
            sequence.add(i)
        }
    }
    return sequence.reversed()
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val sequence = optimalSequence(n)
    println(sequence.size - 1)
    for (x in sequence) {
        print(x.toString() + " ")
    }
}

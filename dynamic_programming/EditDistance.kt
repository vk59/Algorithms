import java.util.*

fun findMinimum(x: Int, y: Int, z: Int): Int {
    var minimum = x
    if (y < minimum) {
        minimum = y
    }
    if (z < minimum) {
        minimum = z
    }
    return minimum
}

fun printArray(ed: Array<Array<Int>>) {
    for (i in 0 until ed.size) {
        for (j in 0 until ed[i].size) {
            print("${ed[i][j]} ")
        }
        println()
    }
}

fun getEditDistance(s: String, t: String): Int {
    val n = s.length
    val m = t.length
    val ed = Array(n + 1, { Array(m + 1, {0}) } )
    for (i in 0..n) {
        ed[i][0] = i
    }
    for (i in 1..m) {
        ed[0][i] = i
    }
    for (i in 1..n) {
        for (j in 1..m) {
            if (s[i - 1] == t[j - 1]) {
                ed[i][j] = ed[i - 1][j - 1]
            } else {
                val a = ed[i][j - 1]
                val b = ed[i - 1][j - 1]
                val c = ed[i - 1][j]
                val min = findMinimum(a, b, c)
                ed[i][j] = min + 1
            }
        }
    }
    return ed[n][m]
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.next()
    val t = scan.next()

    println(getEditDistance(s, t))
}

import java.util.*
import kotlin.math.min

fun findMinimum(vararg nums: Int): Int {
    var m = 1_000_000_001
    for (num in nums) {
        if (m > num) {
            m = num
        }
    }
    return m
}

fun getLongestSequence(ed: Array<Array<Int>>, a: IntArray, b: IntArray, n: Int, m: Int): Int {
    var i = n
    var j = m
    var sequence = 0
    while (i > 0 && j > 0) {
        if (a[i - 1] == b[i - 1]) {
            sequence++
            i--
            j--
        } else {
            var indI = i - 1
            var indJ = j - 1
            var min = ed[indI][indJ]
            var foundEqual = false
            if (min >= ed[i - 1][j] - 1) {
                if (!(foundEqual)) {
                    indI = i - 1
                    indJ = j
                    min = ed[indI][intJ]
                if ((i > 2) && (j > 1) && a[i - 2] == b[j - 1]) {
                    foundEqual = true
                }
            }
            if (min >= ed[i][j - 1] - 1) {
                if (!(foundEqual)) {
                    indI = i
                    indJ = j - 1
                    min = ed[indI][intJ]
                if ((i > 1) && (j > 2) && a[i - 1] == b[j - 2]) {
                    foundEqual = true
                }
            }
            i = indI
            j = indJ
        }
    }
    return sequence
}

fun printArray(ed: Array<Array<Int>>) {
    for (i in 0 until ed.size) {
        for (j in 0 until ed[i].size) {
            print("${ed[i][j]} ")
        }
        println()
    }
}

fun lcs2(a: IntArray, b: IntArray): Int {
    val n = a.size
    val m = b.size
    val editDistance = Array(n + 1, { Array(m + 1, {0}) })
    for (i in 0..n) {
        editDistance[i][0] = i
    }
    for (j in 1..m) {
        editDistance[0][j] = j
    }

    for (i in 1..n) {
        for (j in 1..m) {
            if (a[i - 1] == b[j - 1]) {
                editDistance[i][j] = editDistance[i - 1][j - 1]
            } else {
                val x = editDistance[i - 1][j - 1] + 1
                val y = editDistance[i - 1][j] + 1
                val z = editDistance[i][j - 1] + 1
                editDistance[i][j] = findMinimum(x, y, z)
            }
        }
    }
    /* printArray(editDistance) */
    val lcs = getLongestSequence(editDistance, a, b, n, m)
    return lcs
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }

    val m = scanner.nextInt()
    val b = IntArray(m)
    for (i in 0 until m) {
        b[i] = scanner.nextInt()
    }

    println(lcs2(a, b))
}

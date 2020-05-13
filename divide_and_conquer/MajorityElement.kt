import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun getMajorityElement(a: IntArray, left: Int, right: Int): Int {
    val n = right - left + 1
    if (left == right) return a[left]
    if (left + 1 == right && a[left] == a[right]) return a[left]
    val part1 = getMajorityElement(a, left, (right + left) / 2)
    val part2 = getMajorityElement(a, (right + left) / 2 + 1, right)
    var count1 = 0
    var count2 = 0
    for (i in left..right) {
        if (part1 == a[i]) count1++
        if (part2 == a[i]) count2++
    }
    if (count1 > n / 2) {
        return part1
    }
    if (count2 > n / 2) {
        return part2
    }
    return -1
}

fun getMajorityElementNaive(a: IntArray): Int {
    val n = a.size
    for (i: Int in  0 until n) {
        val currentElement = a[i]
        var count = 0
        for (j: Int in 0 until n) {
            if (a[j] == currentElement) count ++
        }
        if (count > n / 2) return count
    }
    return -1
}

fun main(args: Array<String>) {
    val scanner = FastScanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    if (getMajorityElement(a, 0, a.size - 1) != -1) {
        println(1)
    } else {
        println(0)
    }

    /* STRESS TEST */
    /* val rand = Random()
    while (true) {
        val n = rand.nextInt(10) + 5
        println("N = $n")
        val a = IntArray(n)
        for (i in 0 until n) {
            a[i] = rand.nextInt(4)
            print("${a[i]} ")
        }
        println()
        val res: Int
        val resNaive: Int
        if (getMajorityElement(a, 0, a.size - 1) != -1) {
            res = 1
        } else {
            res = 0
        }
        if (getMajorityElementNaive(a) != -1) {
            resNaive = 1
        } else {
            resNaive = 0
        }
        println("$res :: $resNaive")
        if (res != resNaive) {
            println("result = ${getMajorityElement(a, 0, a.size - 1)}")
            println("ERROR")
            break
        }
    } */
}

class FastScanner(stream: InputStream) {
    var br: BufferedReader = BufferedReader(InputStreamReader(stream))
    var st: StringTokenizer? = null

    fun next(): String {
        while (st == null || !st!!.hasMoreTokens()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextInt() = next().toInt()
}

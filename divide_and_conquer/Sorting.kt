import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

private val random = Random()

fun partition3(a: IntArray, l: Int, r: Int): IntArray {
  val x = a[l]
  var j = l
  var k = l
  for (i in l + 1..r) {
      if (a[i] < x) {
          j++
          k++
          val t = a[i]
          a[i] = a[k]
          a[k] = a[j]
          a[j] = t
      } else if (a[i] == x) {
          k++
          val t = a[i]
          a[i] = a[k]
          a[k] = t
      }
  }
  val t = a[l]
  a[l] = a[j]
  a[j] = t
  return intArrayOf(j, k)
}

fun partition2(a: IntArray, l: Int, r: Int): Int {
    val x = a[l]
    var j = l
    for (i in l + 1..r) {
        if (a[i] <= x) {
            j++
            val t = a[i]
            a[i] = a[j]
            a[j] = t
        }
    }
    val t = a[l]
    a[l] = a[j]
    a[j] = t
    return j
}

fun randomizedQuickSort(a: IntArray, l: Int, r: Int) {
    if (l >= r) {
        return
    }
    val k = random.nextInt(r - l + 1) + l
    val t = a[l]
    a[l] = a[k]
    a[k] = t
    //use partition3
    val m = partition2(a, l, r)
    randomizedQuickSort(a, l, m - 1)
    randomizedQuickSort(a, m + 1, r)
}

fun randomizedQuickSort3(a: IntArray, l: Int, r: Int) {
  if (l >= r) {
      return
  }
  val k = random.nextInt(r - l + 1) + l
  val t = a[l]
  a[l] = a[k]
  a[k] = t
  val ms = partition3(a, l, r)
  randomizedQuickSort3(a, l, ms[0] - 1)
  randomizedQuickSort3(a, ms[1] + 1, r)
}

fun main(args: Array<String>) {
    val scanner = FastScanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    randomizedQuickSort3(a, 0, n - 1)
    for (i in 0 until n) {
        print(a[i].toString() + " ")
    }

    /* STRESS TEST */
    /* val scanner = Scanner(System.`in`)
    val maxN = scanner.nextInt()
    val maxAi = scanner.nextInt()
    while (true) {
        val n = random.nextInt(maxN)
        println("N = $n")
        val a = IntArray(n)
        for (i in 0 until n) {
            a[i] = random.nextInt(maxAi) + random.nextInt(10000)
            print("${a[i]} ")
        }
        println()
        val b = a.clone()
        randomizedQuickSort(a, 0, n - 1)

        randomizedQuickSort3(b, 0, n - 1)
        println("\n")
        var isBreak = false
        for (i in 0 until n) {
            if (b[i] != a[i]) {
                isBreak = true
                println("ERROR index $i value ${a[i]} :: ${b[i]}")
                break
            }
        }
        if (isBreak) {
            break
        }
        println("OK ...")
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

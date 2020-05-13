import java.util.*

fun printMas(a: Array<Int>) {
    for (i in 0 until a.size) {
        print("${a[i]} ")
    }
    println()
}

fun isGreater(a: Array<Int>, b: Array<Int>): Boolean {
    if (a[0] > b[0]) {
        return true
    } else if(a[0] == b[0] && a[1] >= b[1]) return true
    return false
}

fun partition3(a: Array<Array<Int>>, l: Int, r: Int): IntArray {
    val x = a[l]
    var j = l
    var k = l
    for (i in l + 1..r) {
        if (isGreater(x, a[i])) {
            j++
            k++
            val t = a[i]
            a[i] = a[k]
            a[k] = a[j]
            a[j] = t
        }
    }
    val t = a[l]
    a[l] = a[j]
    a[j] = t
    return intArrayOf(j, k)
}

fun quickSort(a: Array<Array<Int>>, l: Int, r: Int) {
    val random = Random()
    if (l >= r) {
        return
    }
    val k = random.nextInt(r - l + 1) + l
    val t = a[l]
    a[l] = a[k]
    a[k] = t
    val ms = partition3(a, l, r)
    quickSort(a, l, ms[0] - 1)
    quickSort(a, ms[1] + 1, r)
}

fun fastCountSegments(starts: IntArray, ends: IntArray, points: IntArray): IntArray {
    val LEFT = 0
    val POINT = 1
    val RIGHT = 2
    val array = Array(starts.size + ends.size + points.size, { Array(2, {0}) } )
    val cnt = Array(points.size, {0})
    for (i in 0 until starts.size) {
        array[i] = arrayOf(starts[i], LEFT)
    }
    for (i in ends.indices) {
        array[starts.size + i] = arrayOf(ends[i], RIGHT)
    }
    for (i in points.indices) {
        array[starts.size + ends.size + i] = arrayOf(points[i], POINT, i)
    }
    /* println("BEFORE SORTING:")
    for (i in array.indices) {
        print("${array[i][0]} ${array[i][1]} :: ")
    } */
    quickSort(array, 0, array.size - 1)
    /* println("AFTER SORTING:")
    for (i in array.indices) {
        print("${array[i][0]} ${array[i][1]} :: ")
    }
    println() */
    val pointCounts: MutableMap<Int,Int> = mutableMapOf()
    for (p in points) {
        pointCounts.put(p, 0)
    }
    var countLefts = 0
    val cntIntArray = IntArray(cnt.size)
    for (i in 0 until array.size) {
        if (array[i][1] == LEFT) countLefts++
        if (array[i][1] == RIGHT) countLefts--
        if (array[i][1] == POINT) {
            val index = array[i][2]
            cntIntArray[index] = countLefts
        }
    }
    return cntIntArray
}

fun naiveCountSegments(starts: IntArray, ends: IntArray, points: IntArray): IntArray {
    val cnt = IntArray(points.size)
    for (i in points.indices) {
        for (j in starts.indices) {
            if (starts[j] <= points[i] && points[i] <= ends[j]) {
                cnt[i]++
            }
        }
    }
    return cnt
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n: Int
    val m: Int
    n = scanner.nextInt()
    m = scanner.nextInt()
    val starts = IntArray(n)
    val ends = IntArray(n)
    val points = IntArray(m)
    for (i in 0 until n) {
        starts[i] = scanner.nextInt()
        ends[i] = scanner.nextInt()
    }
    for (i in 0 until m) {
        points[i] = scanner.nextInt()
    }
    /* val cntNaive = naiveCountSegments(starts, ends, points) */
    val cnt = fastCountSegments(starts, ends, points)
    /* for (x in cntNaive) {
        print(x.toString() + " ")
    }
    println() */
    for (x in cnt) {
        print(x.toString() + " ")
    }

    /* STRESS TEST */
    /* val rand = Random()
    val scanner = Scanner(System.`in`)
    val maxN = scanner.nextInt()
    val maxM = scanner.nextInt()
    val maxStart = scanner.nextInt()
    val maxPoint = maxStart * rand.nextInt(maxN)
    var run = true
    while(run) {
        val n = rand.nextInt(maxN)
        val m = rand.nextInt(maxM)

        val starts = IntArray(n)
        val ends = IntArray(n)
        val points = IntArray(m)
        for (i in 0 until n) {
            starts[i] = rand.nextInt(maxStart) - rand.nextInt(maxStart)
            ends[i] = rand.nextInt(maxStart) + starts[i]
        }
        for (i in 0 until m) {
            points[i] = rand.nextInt(maxPoint) - rand.nextInt(maxPoint)
        }
        val cntNaive = naiveCountSegments(starts, ends, points)
        val cnt = fastCountSegments(starts, ends, points)
        for (i in cnt.indices) {
            if (cnt[i] != cntNaive[i]) {
                run = false
                print("ERROR")
                break
            }
        }
        if (run) {
            println("N = $n\nM = $m")
            print("\nOK .. \n")
        } else {
          for (i in 0 until n) {
              println("${starts[i]} :: ${ends[i]}")
          }
          for (i in 0 until m) {
              print("${points[i]} ")
          }

            println("\nOUTPUTS:")

            for (x in cntNaive) {
                print(x.toString() + " ")
            }
            println()

            for (c in cnt) {
                print(c.toString() + " ")
            }
        }
    } */
}

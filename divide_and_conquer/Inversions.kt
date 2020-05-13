import java.util.*

fun getNumberOfInversions(a: IntArray, left: Int, right: Int): Long {
    var numberOfInversions: Long = 0
    if (right < left + 1) {
        return numberOfInversions
    }
    val ave = (left + right) / 2
    numberOfInversions += getNumberOfInversions(a, b, left, ave)
    numberOfInversions += getNumberOfInversions(a, b, ave + 1, right)
    for(i in left..ave) {
        for (j in (ave + 1)..right) {
            if (a[i] > a[j]) {
                numberOfInversions++
            }
        }
    }
    return numberOfInversions
}

fun getNumberOfInversionsNaive(a: IntArray): Long {
    var numberOfInversions: Long = 0
    for (i in 0 until a.size) {
        for (j in i+1 until a.size) {
            if (a[j] < a[i]) {
                numberOfInversions++
            }
        }
    }
    return numberOfInversions
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    println(getNumberOfInversions(a, 0, a.size - 1))

    /* STRESS TEST */
    /* val scanner = Scanner(System.`in`)
    val maxN = scanner.nextInt()
    val maxAi = scanner.nextInt()
    while(true) {
        val rand = Random()
        val n = rand.nextInt(maxN)
        val a = IntArray(n)
        for (i in 0 until n) {
            a[i] = rand.nextInt(maxAi)
            print("${a[i]} ")
        }
        val b = IntArray(n)
        println()
        val res = getNumberOfInversions(a, b, 0, a.size - 1)
        val resNaive = getNumberOfInversionsNaive(a)
        if (res != resNaive) {
            print("ERROR $res :: $resNaive")
            break
        }
        println("OK ..")
    } */
}

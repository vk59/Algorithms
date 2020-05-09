import java.util.*

fun isGreaterOrEqual(x: String, y: String) : Boolean {
    /* var i: Int = 0
    var a = x
    var b = y
    while (b.length < a.length) {
        b += b[b.length - 1]
    }
    while (a.length < b.length) {
        a += a[a.length - 1]
    }
    return (a >= b) */
    return (x + y > y + x)
}

fun largestNumber(a: MutableList<String>): String {
    val n = a.size
    for (i: Int in 0 until n) {
        for (j: Int in 1 until n-i) {
            if (isGreaterOrEqual(a[j], a[j - 1])) {
                val temp = a[j]
                a[j] = a[j - 1]
                a[j - 1] = temp
            }
        }
    }
    return a.joinToString("")
}

fun largestNumberNaive(a: MutableList<String>): String {
    val n = a.size
    var res = ""
    var maxRes = "0"
    if (n == 2) {
        val sum1 = a[0] + a[1]
        val sum2 = a[1] + a[0]
        if (sum1.toLong() > sum2.toLong()) {
            res += sum1
        } else {
            res += sum2
        }
        return res
    }
      for (i in 0 until n) {
        var b: MutableList<String> = mutableListOf<String>()
        b.addAll(a)
        b.removeAt(i)
        res = a[i] + largestNumberNaive(b)
        if (isGreaterOrEqual(res, maxRes)) {
            maxRes = res
        }
    }
    return maxRes
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = ArrayList<String>(n)
    repeat(n) {
        a += scanner.next()
    }
    println(largestNumber(a))
/*
    while (true) {
        val rand:Random = Random()
        val n = rand.nextInt(20)
        val a = ArrayList<String>(n)
        println("N=$n \n")
        for (i in 1..n) {
            val num: String = (rand.nextInt(1000)).toString()
            print(num + " ")
            a.add(num)
        }
        println()
        val res = largestNumber(a)
        val resNaive = largestNumberNaive(a)
        println(res + " :: " + resNaive)
        if (!res.equals(resNaive)) {
            println("ERROR")
            println("LENGTH: ${res.length} ${resNaive.length}")
            for (i in 0 until res.length) {

                if (res[i] != resNaive[i]) {
                    print("\nPOS: ${i+1} -- NUM: ${res[i]} ${resNaive[i]} \n")
                } else{
                  print(res[i])
                }
            }
            break
        }
    } */
}

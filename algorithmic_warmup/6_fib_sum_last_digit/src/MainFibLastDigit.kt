import java.util.*

fun sumPeriod(a: ArrayList<Int>, n:Long): Long {
    val mas = a.slice(0 until a.size-2)

    var sumMas = 0L
    for (elem in mas){
        sumMas += elem % 10
    }

    val masSize = mas.size
    val countOfOccurrences = n / masSize
    val leftoversNum = n % masSize

    var sum = countOfOccurrences * sumMas % 10

    for (i in 0..leftoversNum){
        sum = (sum + mas[i.toInt()]) % 10
    }
    return sum
}

fun getFibonacciSum(n: Long): Long {
    if (n <= 1){
        return n
    }
    var sum: Long = 1
    val a: ArrayList<Int> = ArrayList()

    var prev: Int = 0
    var curr: Int = 1
    a.add(0)
    a.add(1)

    for (i in 2..n){
        val temp = curr
        curr = (curr + prev) % 10
        prev = temp
        sum = (sum + curr) % 10
        a.add(curr)
        if (prev == 0 && curr == 1){
            sum = sumPeriod(a, n)
            break
        }
    }
    return sum
}

fun getFibonacciSumNaive(n: Long): Long {
    if (n <= 1)
        return n

    var previous: Long = 0
    var current: Long = 1
    var sum: Long = 1

    for (i in 0 until n - 1) {
        val tmpPrevious = previous
        previous = current
        current += tmpPrevious
        sum += current
    }

    return sum % 10
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val s = getFibonacciSum(n)
    println(s)
//    while (true) {
//        val n = (Math.random() * 100).toLong()
//
//        val s = getFibonacciSum(n)
//
//        val s2 = getFibonacciSumNaive(n)
//        println("TEST: $n")
//        println("RESULT $s :: $s2 \n")
//        if (s != s2){
//            break
//        }
//    }
}
import java.util.*
import kotlin.collections.ArrayList


fun SumPeriodFromTo(a: ArrayList<Int>, from: Long, to:Long, firstInd: Long, lastInd: Long): Long {
//    println("A PERIOD   $a")

    val mas = a.slice(firstInd.toInt() until lastInd.toInt())
//    println("MAS PERIOD $mas")
    var sumOfPeriod = 0L

    for (i in 0 until mas.size){
        sumOfPeriod = (sumOfPeriod + mas[i]) % 10
    }

//    println("SUM OF PERIOD: $sumOfPeriod")

    var sumPrePeriod = 0L
    for (i in 0 until firstInd){
        sumPrePeriod = (sumPrePeriod + a[i.toInt()]) % 10
    }


    var sumOverPeriod = 0L
    var leftoversNum = (to - from - firstInd) % mas.size
    var countOfEntries = (to - from - firstInd) / mas.size
//    println("LEFTOVERS COUNT: $leftoversNum")
    for (i in 0..leftoversNum){
        sumOverPeriod = (sumOverPeriod + mas[i.toInt()]) % 10
    }
//    println("SUM OVER PERIOD $sumOverPeriod")

    return (sumOfPeriod * countOfEntries + sumPrePeriod + sumOverPeriod) % 10
}

fun getFibonacciPartialSum(from: Long, to: Long): Long {
    var sum: Long = 0
    val a: ArrayList<Int> = ArrayList()

    var foundedZeroOne = 0
    var firstIndexPeriod = -1

    if (to == 1L) return 1
    else if (from == 0L && to == 0L) return 0
    if (from == 0L){
        foundedZeroOne ++
        firstIndexPeriod = 0
    }
    var curr = 0
    var next = 1
    a.add(curr)
    for (i in 0 until from){
        val newNext = (next + curr) % 10
        curr = next
        next = newNext
        a.add(curr)
        if (i > 1 && curr == 0 && next == 1){
            var periodSize = a.size - 1
            val index = from % periodSize
            curr = a[index.toInt()]
            if (index + 1 < periodSize) {
                next = a[(index + 1).toInt()]
            } else next = 0
            break
        }
    }

    a.clear()

    for (i in from..to){
        sum = (sum + curr) % 10
        val posInA = (i - from - 1).toInt()
        a.add(curr)

        if (posInA > 1) {
            if (a[posInA] == 1 && a[(posInA - 1)] == 0) {
                var indexCurr = posInA
                foundedZeroOne++
                if (foundedZeroOne == 2) {
//                        println("STARTED SumPeriodFromTo")
                    return SumPeriodFromTo(a, from, to, firstIndexPeriod.toLong(), indexCurr.toLong() - 1)
                }
                firstIndexPeriod = indexCurr - 1
            }
        }
        val newNext = (next + curr) % 10
        curr = next
        next = newNext
    }
    return sum
}

fun getFibonacciPartialSumNaive(from: Long, to: Long): Long {
    var sum: Long = 0

    var current: Long = 0
    var next: Long = 1

    for (i in 0..to) {
        if (i >= from) {
            sum  = (sum + current) % 10
        }

        val newCurrent = next
        next = (next + current) % 10
        current = newCurrent
    }

    return sum
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val from = scanner.nextLong()
    val to = scanner.nextLong()
    println(getFibonacciPartialSum(from, to))
//    while (true){
//        val from = (Math.random() * 20).toLong()
//        val to = (from + Math.random() * 300).toLong()
//
//        println("TEST FROM: $from TO: $to")
//
//        val naive = getFibonacciPartialSumNaive(from, to)
//        val notNaive = getFibonacciPartialSum(from, to)
//
//        println("$naive :: $notNaive")
//        if (naive != notNaive) {
//            println("ERROR")
//            break
//        }
//    }
}
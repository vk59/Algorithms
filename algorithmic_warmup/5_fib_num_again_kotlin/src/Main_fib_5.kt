import java.util.*
import kotlin.collections.ArrayList

fun isPeriod(a: ArrayList<Long>): Boolean{
    val halfSize = a.size / 2;
    for (i in 0 until halfSize){
        if (a[i] != a[i + halfSize]){
            return false;
        }
    }
    return true;
}

fun getFibonacciHugeNaive(n: Long, m: Long): Long {
    val a:ArrayList<Long> = ArrayList();
    a.add(0);
    a.add(1);
    var prev = 0L
    var curr = 1L

    while (! isPeriod(a)){
        val temp = curr
        curr = (temp + prev) % m
        prev = temp
        a.add(curr)
    }

    val periodSize = a.size / 2
    val numInPeriod = n % periodSize
    return a[numInPeriod.toInt()]
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val m = scanner.nextLong()
    println(getFibonacciHugeNaive(n, m))
}
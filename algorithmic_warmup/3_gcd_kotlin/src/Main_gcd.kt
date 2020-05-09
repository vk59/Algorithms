@file:Suppress("NAME_SHADOWING")

import java.util.*

fun gcdNaive(a: Int, b: Int): Int {
    var a:Int = a
    var b:Int = b
    if (a < b){
        val temp: Int = a
        a = b
        b = temp
    }
    while (b != 0){
        val c = a % b
        a = b
        b = c
    }
    return a
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()

    println(gcdNaive(a, b))
}
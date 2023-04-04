package com.nichols.dsa.coroutines

import java.util.*

//fun main() = runBlocking {
////    doWorld()
//    noBigDeal()
//}
//
//suspend fun noBigDeal() = coroutineScope{
//    repeat(100_000){
//        launch{
//            delay(5000L)
//            println(".")
//        }
//    }
//}
//
//suspend fun doWorld() = coroutineScope {
//    val job = launch {
//        println("World")
//    }
//    println("Hello")
//    job.join()
//    println("Done")
//}
fun coinchange2(A: ArrayList<Int>, B: Int): Int {
    val ways = IntArray(B + 1)
    val n = A.size
    Arrays.fill(ways, 0)
    ways[0] = 1
    for (i in A.indices)
        for (j in A[i]..B)
            ways[j] += ways[j - A[i]]

    return ways[B]
}
fun largestProduct(A: IntArray): IntArray {
    val n = A.size
    val B = IntArray(n)
    if (n < 3) {
        for (i in 0 until n) {
            B[i] = -1
        }
        return B
    }
    val max = intArrayOf(A[0], A[1], A[2])
    Arrays.sort(max)
    B[0] = -1
    B[1] = -1
    B[2] = max[0] * max[1] * max[2]
    for (i in 3 until n) {
        val x = A[i]
        if (x > max[2]) {
            max[0] = max[1]
            max[1] = max[2]
            max[2] = x
        } else if (x > max[1]) {
            max[0] = max[1]
            max[1] = x
        } else if (x > max[0]) {
            max[0] = x
        }
        B[i] = max[0] * max[1] * max[2]
    }
    return B
}
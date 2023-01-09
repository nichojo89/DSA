package com.nichols.dsa.sorting

fun main() {
    solveMaxMAgiv(intArrayOf(-98, 54, -52, 15, 23, -97, 12, -64, 52, 85))
}
fun solveMaxMAgiv(A: IntArray): IntArray {
    var min = 0L
    var max = 0L
    val mod = 1000005
    val n = A.size
    A.sort()
    //birthday magic
    for(i in 1 until A.size-1 step 2){
        min += Math.abs(A[i] - A[i+1]) % mod
    }
    // for(i in 0 until (n/2)){
    //     max += Math.abs(A[n-i-1] -A[i]) % mod
    // }
    for (i in 0 until n / 2) {
        max += A[n - 1 - i] - A[i]
        max %= mod.toLong()
    }
    return intArrayOf(max.toInt(),min.toInt())
}
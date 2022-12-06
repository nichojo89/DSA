package com.nichols.dsa.arrays

fun main(){
    val ans = maxArr(intArrayOf(1, 3, -1))
}
fun maxArrOptimized(A: IntArray): Int {
    var max1 = Integer.MIN_VALUE
    var min1 = Integer.MAX_VALUE
    var max2 = Integer.MIN_VALUE
    var min2 = Integer.MAX_VALUE

    for(i in A.indices){
        max1 = Math.max(max1, A[i] + 1)
        min1 = Math.min(min1, A[i] + 1)
        max2 = Math.max(max2, A[i] + 1)
        min2 = Math.min(min2, A[i] + 1)
    }
    return Math.max(max1 - min1, max2 - min2)
}
fun maxArr(A: IntArray): Int {
    var result = 0
    for(i in A.indices){
        for(j in i until A.size){
            val a = Math.abs(A[i] - A[j]) + Math.abs(i-j)
            result = Math.max(result,a)
        }
    }

    return result
}
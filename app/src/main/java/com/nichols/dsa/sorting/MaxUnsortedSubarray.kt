package com.nichols.dsa.sorting

fun main() {
    //[min,max]
    val one = subUnsort(intArrayOf(1, 3, 2, 4, 5))
    //[-1]
    val two = subUnsort(intArrayOf(1, 2, 3, 4, 5))
}
fun subUnsort(A: IntArray): IntArray {
    val B = A.sortedArray()
    var min = -1
    var max = -1
    for(i in A.indices){
        if(A[i] != B[i]){
            if(min < 0){
                min = i
            } else {
                max = i
            }
        }
    }

    return if(max == -1) intArrayOf(-1) else intArrayOf(min,max)
}
package com.nichols.dsa.collections

fun main(){
    val a = intArrayOf(5, 15, 7, 6, 3, 4, 18, 14, 13, 7, 3, 7, 2, 18)
    val b = 6
    var c = solveMinAvg(a,b)
}
/**
 * Find subarray of B length with least average.
 * return the index of 1st term in min subarray
 */
fun solveMinAvg(A: IntArray, B: Int): Int {
    var start = 1
    var end = B
    var minSum = Integer.MAX_VALUE
    var minIndex = 0

    if(B == 1){
        //return A.minOrNull()!!
        for(i in A.indices){
            if(A[i] < minSum){
                minSum = A[i]
                start = i
            }
        }
        return start
    }
    //create prefix sum
    for(i in A.indices)
        if(i != 0)
            A[i] = A[i-1] + A[i]



    var sum = A[end-1]
    minSum = sum

    while(end < A.size){
        val ee = A[end]
        val ss = A[start-1]
        sum = ee - ss
         if(sum < minSum){
            minSum = sum
            minIndex = start
        }

        start++
        end++
    }
    return minIndex
}
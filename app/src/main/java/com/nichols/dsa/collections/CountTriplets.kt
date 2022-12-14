package com.nichols.dsa.collections

import com.nichols.dsa.binary.BitMan


fun main(){
    //solve(intArrayOf(1, 2, 4, 3))
//    val a = intArrayOf(1,3,5)
//    val b = intArrayOf(1,2,3)
//    val c = findTripleChristmasTrees(a,b)
//    val d = 0
//    GenerateAllSubArrays().solve(intArrayOf(1, 2, 3))
    BitMan().solve(5, intArrayOf(0, 1, 1, 0, 1 ))
}


fun solve(A: Int, B: IntArray): Long {
    var count = 0L
    for (i in 0 until A) {
        for (j in i until A) {
            var bitwise_or = 0

            //traverse from i to j
            for (k in i..j) {
                bitwise_or = bitwise_or or B[k]
            }
            if (bitwise_or >= 1) count++
        }
    }
    return count
}


//return lowest price of 3 consecutive trees
fun findTripleChristmasTrees(A: IntArray, B: IntArray): Int{
    //A == height
    //B == cost
    var cost = Integer.MAX_VALUE
    for(j in 1 until A.size){
        var left = Integer.MAX_VALUE
        var right = Integer.MAX_VALUE

        //# of smaller elements on left
        for(i in 0 until j){
            if(A[i] < A[j])
                left = Math.min(left, B[i])
        }
        //# of smaller elements on right
        for(k in j+1 until A.size)
            if(A[k] > A[j])
                right = Math.min(right, B[k])

        //cost += (left * right)
        if(left != Int.MAX_VALUE
            && right != Integer.MAX_VALUE){
            cost = Math.min(cost,B[j] +
            left + right)
        }
    }

    if(cost == Integer.MAX_VALUE)
        return -1

    return cost
}
fun solve(A: IntArray): Int {
    var ans = 0
    for(j in 1 until A.size){
        var left = 0
        var right = 0

        //count of smaller elements on left
        for(i in 0 until j){
            if(A[i] < A[j])
                left++
        }
        //count of larger elements on right
        for(k in j+1 until A.size){
            if(A[k] > A[j])
                right++
        }

        ans += (left * right)
    }
    return ans
}
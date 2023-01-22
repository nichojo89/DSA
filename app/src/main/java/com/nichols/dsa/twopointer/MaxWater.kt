package com.nichols.dsa.twopointer

fun solvemaxAreaWater(A: IntArray): Int {
    var i = 0
    val n = A.size
    var j = n-1
    var ans = 0
    while(i < j){
        ans = Math.max(ans,(j-i) * Math.min(A[i], A[j]))

        if(A[i] <= A[j])
            i++
        else
            j--
    }
    return ans
}
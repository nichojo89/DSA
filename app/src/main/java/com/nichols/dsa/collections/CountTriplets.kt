package com.nichols.dsa.collections

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
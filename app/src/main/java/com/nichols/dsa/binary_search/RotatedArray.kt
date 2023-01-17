package com.nichols.dsa.binary_search

fun solveRotatedBinary(A:IntArray, B: Int): Int {
    val n = A.size
    var l = 0
    var r = n-1
    while(l <= r){
        val m = l + (r-l)/2
        if(A[m] == B)
            return m
        else if(A[m] >= A[l]){
            if(B <= A[m] && B >= A[l])
                r = m-1
            else
                l = m+1
        } else {
            if(B >= A[m] && B <=A[r])
                l = m+1
            else
                r = m-1
        }
    }
    return -1
}
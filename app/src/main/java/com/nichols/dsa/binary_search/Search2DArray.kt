package com.nichols.dsa.binary_search

fun solve(A: Int, B: Int, C: Array<IntArray>): Int {
    //BRUTE FORCE
    var min = Integer.MAX_VALUE;

    for(i in C.indices){
        var rowMin = Integer.MAX_VALUE
        for(j in 0 until C[i].size-1)
            rowMin = Math.min(rowMin,Math.abs(C[i][j] - C[i][j+1]))

        min = Math.min(min,rowMin)
    }
    return min
}

fun searchMatrixBinary(A: Array<IntArray>, B: Int): Int {
    val n = A.size
    val m = A[0].size
    var left = 0
    var right = A.size*m-1

    while(left <= right){
        val mid = (right+left)/2
        val i = mid/m
        val j = mid%m

        if(A[i][j] == B)
            return 1
        else if(A[i][j] < B)
            left = mid+1
        else
            right = mid-1
    }

    return 0
}
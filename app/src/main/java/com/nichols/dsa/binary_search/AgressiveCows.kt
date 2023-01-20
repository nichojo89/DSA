package com.nichols.dsa.binary_search

class AgressiveCows {
    fun solve(A: IntArray, B: Int): Int {
        A.sort()
        var right = A.last()
        var left = 0
        while(left <= right){
            val mid = left + (right-left)/2
            if(check(A,B,mid))
                left = mid+1
            else
                right = mid-1
        }
        return right
    }
    fun check(A:IntArray, cows: Int, mindDistance: Int): Boolean {
        var cowsCount = 1
        var lastCow = A[0]
        val n = A.size
        for(i in 1 until n)
            if(A[i]- lastCow >= mindDistance){
                cowsCount++
                lastCow = A[i]
            }
        return cowsCount >= cows
    }
}
package com.nichols.dsa.hashing

fun main(){
    val f = solveFirstDistinct(intArrayOf(10, 5, 3, 4, 3, 5, 6))
    val fsdf = 0
}

    fun solveFirstDistinct(A: IntArray): Int {
        val freqMap = hashMapOf<Int,Int>()
        for(i in A.indices){
            freqMap[A[i]] = if(freqMap.containsKey(A[i]))
                freqMap[A[i]]!!+1
            else
                1
        }
        for(i in A)
            if(freqMap[i]!! > 1)
                return i

        return -1
    }
package com.nichols.dsa.hashing
fun main(){
    solveFindFrequencies(
        intArrayOf(6, 3, 3, 6, 7, 8, 7, 3, 7),
        intArrayOf(10, 9, 8))
}

fun solveFindFrequencies(A: IntArray, B: IntArray): IntArray {
    val freqMap = hashMapOf<Int, Int>()

    //create frequency array
    for (i in A.indices) {
        if (freqMap.containsKey(A[i]))
            freqMap[A[i]] = freqMap[A[i]]!! + 1
        else
            freqMap[A[i]] = 1
    }
    //turn B into array of frequencies
    for (i in B.indices)
        if (freqMap.containsKey(B[i]))
            B[i] = freqMap[B[i]]!!
        else
            B[i] = 0

    return B
}
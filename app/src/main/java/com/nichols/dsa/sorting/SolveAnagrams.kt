package com.nichols.dsa.sorting

fun main(){
    val t1 = solveAnagrams("u","u")
    val f = solveAnagrams("cat","bat")
    val t2 = solveAnagrams("secure", "rescue")
    val g = 9
}

fun solveAnagrams(A: String, B: String): Int {
    if(A.length != B.length)
        return 0

    //count the frequencies
    val aFreq = IntArray(26)
    val bFreq = IntArray(26)
    for(i in A.indices){
        val aIndex = A[i] - 'a'
        aFreq[aIndex] += 1

        val bIndex = B[i] - 'a'
        bFreq[bIndex] += 1
    }

    return if(bFreq.contentEquals(aFreq)) 1 else 0
}
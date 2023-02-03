package com.nichols.dsa.hashing

fun main(){
    val five = solveNumPermuationsOfAInB("abc","abcbacabc")
    val two = solveNumPermuationsOfAInB("aca","acaa")
}
fun solveNumPermuationsOfAInB(A: String, B: String): Int {
    val n = A.length
    val m = B.length
    val freqA = IntArray(26)
    //update frequency of each char in A
    for(c in A)
        freqA[c-'a']++

    val freqB = IntArray(26)

    for(i in 0..n)
        freqB[B[i]-'a']++

    var count = 0

    for(i in n .. m){
        if(check(freqA,freqB))
            count++

        freqB[B[i-n] - 'a']--
        freqB[B[i] - 'a']++
    }
    if(check(freqA,freqB))
        count++

    return count
}

fun check(A:IntArray,B:IntArray): Boolean{
    var c = 'a'
    while (c <= 'z'){
        if(A[c-'a'] != B[c-'a'])
            return false
        ++c
    }
    return true
}
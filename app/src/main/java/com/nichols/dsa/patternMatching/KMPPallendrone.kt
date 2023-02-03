package com.nichols.dsa.patternMatching

fun main(){
    val two = solveKMPPalindrome("abc")
    val zero = solveKMPPalindrome("bb")
}
fun solveKMPPalindrome(A: String): Int {
    val revS = A.reversed()
    val concat = "$A$$revS"
    val lps = computeLPSArray(concat,concat.length, IntArray(concat.length))
    return A.length - lps.last()
}

fun computeLPSArray(pat: String, M: Int, lps: IntArray) : IntArray {
    // length of the previous longest prefix suffix
    var len = 0
    var i = 1
    //first variable will always be zero
    lps[0] = 0

    //for length of concat string
    while (i < M) {
        //if there's a match
        if (pat[i] == pat[len]) {
            //keep incrementing
            len++
            lps[i] = len
            i++
        } else
        {
            // Reset to nearest neighbor, i is not incremented
            if (len != 0) {
                len = lps[len - 1]
            } else
            {
                //new match
                lps[i] = len
                i++
            }
        }
    }
    return lps
}
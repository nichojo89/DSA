package com.nichols.dsa.combinicators

fun main(){
    val ans = solve(5,2,13)
}

fun solve(A: Int, B: Int, C: Int): Int {
    val dp = Array(A + 1) { IntArray(B + 1) }
    for (i in 0..A) {
        for (j in 0..Math.min(i, B)) {
            if (j == i || j == 0) {
                dp[i][j] = 1
            } else {
                // nCr = (n - 1)C(r - 1) + (n - 1)Cr
                //carry forward nCR
                dp[i][j] = (dp[i - 1][j - 1] % C + dp[i - 1][j] % C) % C
            }
        }
    }
    return dp[A][B] % C
}
//fun solve(A: Int, B: Int, C: Int): Int {
//    //Attemp #1, calculate everything in 1 line
//    //return (factorial(A) / (factorial(B) * factorial(A - B)) % C).toInt()
//    val mod = C
//    //Attemp #2, break the problem out
//    val nFact = factorial(A,mod)
//    val denom = factorial(A-B,mod)
//    val rFact = factorial(B,mod)
//
//    val ncr = nFact / (denom * rFact)
//
//    //return nCr%m
//    return (ncr % C).toInt()
//}

fun factorial(n: Int, m: Int): Long{
    return if(n >= 1)
        n * factorial(n-1,m)
    else
        1
}
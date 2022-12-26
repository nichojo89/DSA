package com.nichols.dsa.prime

fun main(){
    //val ans = solveLuckyNumber(12)
}
fun solve(A: Int, M: Int) : Int {
    val g = gcd(A, M)
    return if (g != 1) 0 else {
        power(A, M - 2, M)
    }
}

fun power(x: Int, y: Int, M: Int): Int {
    if (y == 0) return 1
    var p = power(x, y / 2, M) % M
    p = (p * p.toLong() % M).toInt()
    return if (y % 2 == 0) p else (x * p.toLong() % M).toInt()
}

fun gcd(a: Int, b: Int): Int {
    return if (a == 0) b else gcd(b % a, a)
}
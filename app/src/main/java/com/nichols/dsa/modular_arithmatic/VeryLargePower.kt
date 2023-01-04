package com.nichols.dsa.modular_arithmatic
fun main(){
    val ans = solveVeryLargePower(2,27)
}
fun solveVeryLargePower(A: Int, B: Int): Int {
    val fact = factorial(B)
    val mod = (1e9+7)
    val ans = fastPower(A, fact, mod)

    return ans
}

//Denominator is root while numerator is power
fun fastPower(D: Int, N: Long, M: Double): Int {
    var ans = 1.0
    var B = N
    var A = D

    while(B > 0){
        //If B is odd binary
        if(B and 1L == 1L)
            //keep adding mod
            ans = (ans * A) % M
        //even --> A^n/2 * A^n/2
        //odd  --> A^n/2 * A^n/2 * A
        A = ((A % M * A % M) % M).toInt()
        B = B shl 1
    }

    return (ans % M).toInt()
}

fun factorial(n: Int): Long{
    return if(n >= 1)
        n * factorial(n-1)
    else
        n.toLong()
}


fun solve(A: Int, B: Int): Int {
    var fact = 1L
    val mod = java.lang.Double.valueOf(1e9 + 7).toLong()
    var i = 2L
    while (i <= B) {
        fact = fact * i % (mod - 1)
        i += 1
    }
    return fastPower(A, fact, mod)
}

fun fastPower(A: Int, B: Long, mod: Long): Int {
    var A = A
    var B = B
    var ans: Long = 1
    while (B > 0) {
        if (B and 1 == 1L) {
            ans = ans * A % mod
        }
        A = (A % mod * A % mod % mod).toInt()
        B = B shr 1
    }
    return (ans % mod).toInt()
}
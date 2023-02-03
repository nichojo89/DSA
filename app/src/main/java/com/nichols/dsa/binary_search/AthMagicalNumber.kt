package com.nichols.dsa.binary_search

fun gcd(x: Int, y: Int): Int {
    return if (x == 0) y else gcd(y % x, x)
}

fun solveAthMagicalNumber(A: Int, B: Int, C: Int): Int {
    // lcm of B and C
    val lcm = B.toLong() * C / gcd(B, C)
    var low: Long = 2
    var high = A.toLong() * Math.min(B, C)
    var ans: Long = 0
    while (low <= high) {
        val mid = (high - low) / 2 + low
        // f(x) = x / B + x / C - x / lcm(B, C)
        val cntB = mid / B
        val cntC = mid / C
        val cntBC = mid / lcm
        if (cntB + cntC - cntBC >= A) {
            ans = mid
            high = mid - 1
        } else low = mid + 1
    }
    return (ans % (1000 * 1000 * 1000 + 7)).toInt()
}
package com.nichols.dsa.combinicators

class nCrModP {
    fun solve(A: Int, B: Int, C: Int): Int {
        if (C == 1) return 0
        if (A == 1) return 1
        val mx = Math.max(A - B, B).toLong()
        val mn = Math.min(A - B, B).toLong()
        var denominator: Long = 1
        var numerator: Long = 1

        for (n in mx + 1 until A + 1) {
            numerator = numerator * n % C
        }
        for (d in 2 until mn + 1) {
            denominator = denominator * d % C
        }
        return (numerator * pow(denominator, C - 2, C) % C).toInt()
    }

    fun pow(x: Long, y: Int, k: Int): Long {
        var x = x
        var y = y
        var result: Long = 1
        while (y > 0) {
            if (y % 2 == 1) {
                result = result * x % k
                y--
            }
            y = y shr 1
            x = x * x % k
        }
        return result
    }
}
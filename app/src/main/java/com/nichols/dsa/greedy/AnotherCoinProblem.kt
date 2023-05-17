package com.nichols.dsa.greedy

class AnotherCoinProblem {
    fun solve(A: Int): Int {
        var A = A
        val coinValues = intArrayOf(1, 5, 25, 125, 625, 3125, 15625)
        var count = 0
        for (i in coinValues.indices.reversed()) {
            val coinsNeeded = A / coinValues[i]
            count += coinsNeeded
            A -= coinsNeeded * coinValues[i]
        }
        return count
    }
}
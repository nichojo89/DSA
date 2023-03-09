package com.nichols.dsa.heaps

class NumHeaps {
    var MAXN = 105
    var dp = IntArray(MAXN)
    var nck = Array(MAXN) { IntArray(MAXN) }
    var log2 = IntArray(MAXN)

    fun solve(n: Int): Int {
        for (i in 0..n)
            dp[i] = -1

        for (i in 0..n)
            for (j in 0..n)
                nck[i][j] = -1

        var currLog2 = -1
        var currPower2 = 1

        for (i in 1..n) {
            if (currPower2 == i) {
                currLog2++
                currPower2 *= 2
            }
            log2[i] = currLog2
        }
        return numberOfHeaps(n)
    }

    fun choose(n: Int, k: Int): Int {
        if (k > n)
            return 0

        if (n <= 1)
            return 1

        if (k == 0)
            return 1

        if (nck[n][k] != -1)
            return nck[n][k]

        val answer = choose(n - 1, k - 1) + choose(n - 1, k)
        nck[n][k] = answer
        return answer
    }

    fun getLeft(n: Int): Int {
        if (n == 1)
            return 0

        val h = log2[n]
        val numh = 1 shl h
        val last = n - ((1 shl h) - 1)

        return if (last >= numh / 2) {
            (1 shl h) - 1 // (2^h) - 1
        } else {
            (1 shl h) - 1 - (numh / 2 - last)
        }
    }

    fun numberOfHeaps(n: Int): Int {
        if (n <= 1)
            return 1

        if (dp[n] != -1)
            return dp[n]

        val left = getLeft(n)
        val ans = (choose(n - 1, left) * numberOfHeaps(left) * numberOfHeaps(n - 1 - left))
        dp[n] = ans
        return ans
    }
}
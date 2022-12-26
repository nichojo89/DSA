package com.nichols.dsa.prime

import java.util.*

class FactorialPrimes {
    private val prime = IntArray(1000001)
    private val mod = 1000 * 1000 * 1000 + 7

    /**
     * Creates prime seive of integers
     */
    fun pre() {
        // sieve of eratosthenes
        val maxN = 1000001
        prime[1] = 1
        for (i in 2 until maxN) {
            if (prime[i] == 0) {
                var j = 2 * i
                while (j < maxN) {
                    prime[j] = 1
                    j += i
                }
            }
        }
    }

    fun power(x: Long, y: Long): Int {
        // modular exponentiation
        var x = x
        var y = y
        var res: Long = 1
        while (y != 0L) {
            if (y % 2 == 1L) {
                res = x * res % mod
            }
            y /= 2
            x = x * x % mod
        }
        return res.toInt()
    }

    fun solve(A: IntArray): Int {
        //create sieve
        pre()
        val n = A.size
        //sort input
        Arrays.sort(A)
        val v = IntArray(100000)
        var itr = 0
        // stores all the prime numbers
        for (i in 2..A[n - 1]) {
            if (prime[i] == 0) {
                v[itr] = i
                itr++
            }
        }
        var ans: Long = 0
        var j = 0
        var i = 0
        while (i < n && j < itr) {
            // find the count of elements with same set of non-empty prime factors
            var cnt = 0
            if (A[i] == 1) {
                i++
                continue
            }
            while (i < n && A[i] < v[j]) {
                i++
                cnt++
            }
            val temp = (power(2, cnt.toLong()) - 1).toLong()
            ans = (ans + temp) % mod
            j++
        }
        if (i < n) {
            val temp = (power(2, (n - i).toLong()) - 1).toLong()
            ans = (ans + temp) % mod
        }
        return ans.toInt()
    }
}

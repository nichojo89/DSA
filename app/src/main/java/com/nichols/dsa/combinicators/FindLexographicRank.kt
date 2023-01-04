package com.nichols.dsa.combinicators

class FindLexographicRank {
    private val MOD = 1000003

    /**
     * Finds lexographic rank amungst all possible character chars
     */
    fun findRank(A: String): Int {
        val charCount = ArrayList<Int>(256)

        for (i in 0..255) charCount.add(0)
            for (i in 0 until A.length) {
                val ch = A[i].code
                charCount[ch] = charCount[ch] + 1
            }

        // fact[i] will contain i! % MOD
        val fact = ArrayList<Int>()

        initializeFactorials(A.length + 1, fact)

        var rank: Long = 1
        for (i in A.indices) {
            var less: Long = 0
            val remaining = A.length - i - 1
            var ch = 0

            while (ch < A[i].code) {
                if (charCount[ch] === 0) {
                    ch++
                    continue
                }

                charCount[ch] = charCount[ch] - 1
                var numPermutation = fact[remaining].toLong()
                for (c in 0..127) {
                    if (charCount[c] <= 1)
                        continue

                    numPermutation = numPermutation * inverseNumber(fact[charCount[c]]) % MOD
                }
                charCount[ch] = charCount[ch] + 1
                less = (less + numPermutation) % MOD
                ch++
            }

            rank = (rank + less) % MOD

            // remove the current character from the set.
            charCount[A[i].code] = charCount[A[i].toInt()] - 1
        }
        return rank.toInt()
    }

    /**
     * Calculates factorial
     */
    private fun initializeFactorials(totalLen: Int, fact: ArrayList<Int>) {
        var factorial = 1L
        fact.add(1)
        // 0!= 1
        for (curIndex in 1 until totalLen) {
            factorial = factorial * curIndex % MOD
            fact.add(factorial.toInt())
        }
        return
    }

    fun pow(a: Long, b: Int, k: Int): Long {
        var x = a
        var y = b
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

    /**
     * // Find the modular multiplicative inverse.
     * Calculates (num ^ (MOD - 2)) % MOD
     */
    fun inverseNumber(num: Int): Long = pow(num.toLong(), MOD - 2, MOD)
}
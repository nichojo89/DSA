package com.nichols.dsa.prime

class OverlappingRectangle {
    private val mod = 1000003
    fun findRank(A: String): Int {
        val s = A
        var ans = 0
        val n = s.length

        for(i in s.indices){
            var count = 0
            for(j in i+1 until n)
                if(s[j] < s[i])
                    count++

            ans += (count * fact(n-i-1)) % mod
        }
        return ans
    }

    fun fact(n: Int): Int =
        if(n<=1) 1 else (n*fact(n-1)) % mod
}
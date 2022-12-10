package com.nichols.dsa.binary

fun cntBits(A: IntArray): Int {
    val mod = 1000000007
    var ans = 0L
    var count = 0

    for(i in 0 until 32){
        count = 0
        for(j in A.indices)
            if(A[j] and (1 shl i)> 0)
                count++
        ans += 2 * count * (A.size-count)
        ans %= mod
    }
    return ans.toInt()
}
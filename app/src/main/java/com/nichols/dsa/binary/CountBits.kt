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
fun main(){
    val ans = divide(-2147483648,-1)
}

fun divide(A: Int, B: Int): Int {
    var n = A
    var m = B
    var sign = 1
    if(n < 0)
        sign = -sign
    if(m < 0)
        sign = -sign
    n = Math.abs(n)
    m = Math.abs(m)
    var q = 0L

    for(i in 0 until 31)
        if((m shl i) <= n){
            n -= (m shl i)
            q += (1 shl i)
        }

    if(sign < 0)
        q = -q

    if(q > Integer.MAX_VALUE)
        return Integer.MAX_VALUE
    else
        return q.toInt()
}

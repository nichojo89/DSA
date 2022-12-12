package com.nichols.dsa.binary

import java.util.*

fun main(){
    val ans = findMinXor(intArrayOf(15, 5, 1, 10, 2))
}
fun findMinXor(A: IntArray): Int {
    var ans = Integer.MAX_VALUE
    for(i in A.indices)
        for(j in (i+1) until A.size)
            ans = Math.min(ans, A[i] xor A[j])
    return ans
}
fun findMinXorTwo(A: IntArray): Int {
    Arrays.sort(A)

    var ans = Integer.MAX_VALUE
    var value = 0
    for(i in 0 until A.size-1) {
        value = A[i] xor A[i+1]
        ans = Math.min(ans,value)
    }
    return ans
}

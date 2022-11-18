package com.nichols.dsa.hashing

fun main(){
    val t = solveLongSubArraySum(intArrayOf(1, -2, 1, 2),
    0)
}
fun solveLongSubArraySum(A: IntArray, B: Int): Int {
    var ans = Integer.MAX_VALUE
    for(i in A.indices){
        val a = A[i]
        val b = B-a
        for(j in i+1 until A.size)
            if(A[j] == b && j-i < ans)
                ans = j-i
    }
    return ans
}
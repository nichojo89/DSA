package com.nichols.dsa.dynamicprogramming

fun solve(A: IntArray): Int {
    val n = A.size
    val index = hashMapOf<Int,Int>()
    for(i in A.indices)
        index[A[i]] = i

    val longest = Array(n){IntArray(n)}
    var ans = 0

    for(k in A.indices)
        for(j in 0..k)
            if(A[k] - A[j] < A[j] && index.containsKey(A[k] - A[j])){
                val i = index[A[k] - A[j]]!!
                longest[j][k] = longest[i][j] + 1
                ans = Math.max(ans,longest[j][k] + 2)
            }

    if(ans >=3)
        return ans

    return 0
}
class DistinctSubSequences {
    fun numDistinct(A: String, B: String): Int =
        subCounter(A,B,A.length,B.length)

    fun subCounter(A: String, B: String, n: Int, m: Int) : Int {
        val previous = IntArray(m+1);
        previous[0] = 1
        val mod = (Math.pow(10.0,9.0)+7).toInt()
        for(i in 1..n+1)
            for(j in m downTo 0)
                if(A[i-1]==B[j-1])
                    previous[j] = (previous[j-1] + previous[j]) % mod
        else
            previous[j] = previous[j]

        return  previous[m]
    }

//    fun subsequenceCounting(s1: String, s2: String, n: Int, m: Int): Int {
//        // Write your code here.
//        val prev = IntArray(m + 1)
//        prev[0] = 1
//        for (i in 1 until n + 1) {
//            for (j in m downTo 1) { // Reverse direction
//                if (s1[i - 1] == s2[j - 1]) prev[j] = (prev[j - 1] + prev[j]) % prime else prev[j] =
//                    prev[j] //can omit this statemwnt
//            }
//        }
//        return prev[m]
//    }
}
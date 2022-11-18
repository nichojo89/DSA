package com.nichols.dsa.hashing

fun main(){
    solveCountPairSum(intArrayOf(1, 2, 1, 2),3)
}
fun solveCountPairSum(A: IntArray, B: Int): Int {
    var count = 0
    for(i in A.indices) {
        val a = A[i]
        val b = B-a
        for(j in i+1 until A.size){
            if(A[j] == b)
                count++
        }
    }
    return count
}

fun solve(A: IntArray, B: Int): Int {
    val freq: MutableMap<Int, Int> = HashMap()
    val mod = (1e9 + 7).toInt()
    var ans: Long = 0
    for (i in A.indices) {
        if (freq.containsKey(B - A[i])) {
            ans = (ans + freq[B - A[i]]!!) % mod
        }
        freq[A[i]] = freq.get(A[i])!! + 1
    }
    return ans.toInt()
}
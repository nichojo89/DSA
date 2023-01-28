package com.nichols.dsa.hashing

fun solveCountSubArrays(A: IntArray): Int {
    val hs: HashSet<Int> = HashSet()
    var ans: Long = 0
    val N = A.size
    var l = 0
    for (r in 0 until N) {
        // check if A[r] is already there in the present window
        while (hs.contains(A[r])) {
            hs.remove(A[l])
            l++
        }
        // add the subarrays ending at position r
        ans += (r - l + 1).toLong()
        hs.add(A[r])
    }
    return (ans % (1e9 + 7).toLong()).toInt()
}
package com.nichols.dsa.twopointer

fun solveFindPair(A: IntArray, B: Int): Int {
    val mpp = hashMapOf<Int,Int>()

    var count = 0

    for (i in A.indices) {
        // Update frequency
        mpp[A[i]] = mpp[A[i]]!! + 1

        if (B == 0 && mpp[A[i]]!! > 1)
            count++
    }

    if (B == 0)
        return count

    for (i in A.indices) {
        if (mpp.containsKey(B + A[i])) {
            count++
        }
    }
    return count
}
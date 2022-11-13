package com.nichols.dsa

/**
 * Does a pair exist with sum of zero
 */
fun solvePairSumZero(A: Int, B: IntArray): Int {
    val hs = hashSetOf<Int>()
    for(i in B.indices)
    {
        //query
        val a = B[i]
        val b = A-a
        if(hs.contains(b)){
            return 1
        }
        hs.add(B[i])
    }
    return 0
}

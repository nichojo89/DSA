package com.nichols.dsa.hashing

fun solveCountDistincts(A: IntArray): Int {
    val hs = hashSetOf<Int>()
    for(i in A)
        hs.add(i)

    return hs.size
}
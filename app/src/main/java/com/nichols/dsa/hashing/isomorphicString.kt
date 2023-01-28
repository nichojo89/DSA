package com.nichols.dsa.hashing

import java.util.*

fun solveAAAA(A: IntArray, B: Int): Int {
    A.sort()
    var count = 0


    for(i in A.indices)
        if(A[i] == A[i+1]){
            count++
        }

    return count/2
}

fun countDistictSubarray(A: IntArray): Int {
    val n = A.size
    val hs = hashSetOf<Int>()
    for (i in A.indices)
        hs.add(A[i])

    val totalDist = hs.size
    var count = 0
    for (i in A.indices) {
        val hs2 = hashSetOf<Int>()
        for (j in i until n) {
            hs2.add(A[j])
            if (hs2.size == totalDist)
                count++
        }
    }
    return count
}
fun solveIsomorphic(A: String, B: String): Boolean {
    val m = A.length
    val n = B.length
    val size  = 256

    if (m != n)
        return false


    val marked = arrayOfNulls<Boolean>(size)
    Arrays.fill(marked, java.lang.Boolean.FALSE)

    val map = IntArray(size)
    Arrays.fill(map, -1)

    for (i in 0 until n) {

        if (map[A[i].code] == -1) {
            if (marked[B[i].code] == true)
                return false

            marked[B[i].code] = true

            map[A[i].code] = B[i].code
        }
        else if (map[A[i].code] != B[i].code)
            return false
    }
    return true
}
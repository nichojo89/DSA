package com.nichols.dsa.sorting

import java.util.*

fun main() {
    val A = arrayOf(intArrayOf(1,3), intArrayOf(-2,2))
    val B = 1

    solvepClosest(A,B)
}
fun solvepClosest(A: Array<IntArray>, B: Int): Array<IntArray> {
    val n = A.size
    val distance = IntArray(n)
    val ans = arrayListOf<IntArray>()
    for (i in 0 until n) {
        val x = A[i][0]
        val y = A[i][1]
        distance[i] = x * x + y * y
    }

    Arrays.sort(distance)
    val kDistance = distance[B - 1]
    for (i in 0 until n) {
        val x = A[i][0]
        val y = A[i][1]
        val dist = x * x + y * y
        if (dist <= kDistance)
            ans.add(intArrayOf(x,y))
    }
    return ans.toTypedArray()
}
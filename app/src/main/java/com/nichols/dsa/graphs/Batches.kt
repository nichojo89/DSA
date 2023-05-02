package com.nichols.dsa.graphs

import java.util.*
internal class Solution {
    class Pair(var row: Int, var col: Int, var tm: Int)
    fun solve(A: Array<IntArray>): Int {
        val n = A.size
        val m = A[0].size
        val pairQueue: Queue<Pair> = LinkedList()

        val visited = Array(n) { IntArray(m) }
        var newCount = 0
        for (i in 0 until n)
            for (j in 0 until m) {
                if (A[i][j] == 2) {
                    pairQueue.add(Pair(i, j, 0))
                    visited[i][j] = 2
                } else
                    visited[i][j] = 0

                if (A[i][j] == 1)
                    newCount++
            }

        var tm = 0
        var cnt = 0
        val dcol = intArrayOf(0, 1, 0, -1)
        val drow = intArrayOf(-1, 0, +1, 0)

        while (!pairQueue.isEmpty()) {
            val r = pairQueue.peek()?.row
            val c = pairQueue.peek()?.col
            val t = pairQueue.peek()?.tm
            tm = Math.max(tm, t!!)
            pairQueue.remove()

            for (i in 0..3) {
                val nrow = r?.plus(drow[i])
                val ncol = c?.plus(dcol[i])

                if (ncol != null) {
                    if (nrow in 0 until n && ncol >= 0 && ncol < m && visited[nrow!!][ncol] == 0 && A[nrow][ncol] == 1) {
                        pairQueue.add(Pair(nrow, ncol, t + 1))
                        visited[nrow][ncol] = 2
                        cnt++
                    }
                }
            }
        }

        return if (cnt != newCount) -1 else tm
    }
}
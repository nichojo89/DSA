package com.nichols.dsa.graphs

import java.util.*

class MazeShortDistance {
    private val DIRS =
        arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(1, 0))

    fun solve(A: Array<IntArray>, B: IntArray, C: IntArray): Int {
        val distance = Array(A.size) { IntArray(A[0].size) }
        for (row in distance) {
            Arrays.fill(row, Int.MAX_VALUE)
        }
        distance[B[0]][B[1]] = 0
        val queue: Queue<IntArray> = LinkedList()
        queue.add(B)
        while (!queue.isEmpty()) {
            val position = queue.poll()
            for (dir in DIRS) {
                var x = position[0]
                var y = position[1]
                var count = 0
                while (x >= 0 && y >= 0 && x < A.size && y < A[0].size && A[x][y] == 0) {
                    x += dir[0]
                    y += dir[1]
                    count++
                }
                x -= dir[0]
                y -= dir[1]
                count--
                if (distance[position[0]][position[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[position[0]][position[1]] + count
                    queue.add(intArrayOf(x, y))
                }
            }
        }
        return if (distance[C[0]][C[1]] == Int.MAX_VALUE) -1 else distance[C[0]][C[1]]
    }
}
package com.nichols.dsa.graphs

import java.util.*

class Mediamn
{
    data class Point(val x: Int, val y: Int, val steps: Int)

    fun isInsideBoard(x: Int, y: Int, A: Int, B: Int): Boolean {
        return x in 1..A && y in 1..B
    }

    fun knight(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int): Int {
        val dx = arrayOf(-2, -1, 1, 2, -2, -1, 1, 2)
        val dy = arrayOf(-1, -2, -2, -1, 1, 2, 2, 1)

        val visited = Array(A + 1) { BooleanArray(B + 1) }
        val queue = ArrayDeque<Point>()

        queue.offer(Point(C, D, 0))
        visited[C][D] = true

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            if (current.x == E && current.y == F) {
                return current.steps
            }

            for (i in 0 until 8) {
                val newX = current.x + dx[i]
                val newY = current.y + dy[i]

                if (isInsideBoard(newX, newY, A, B) && !visited[newX][newY]) {
                    visited[newX][newY] = true
                    queue.offer(Point(newX, newY, current.steps + 1))
                }
            }
        }

        return -1
    }
}
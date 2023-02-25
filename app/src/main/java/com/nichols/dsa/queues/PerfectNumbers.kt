package com.nichols.dsa.queues


class PerfectNumbers {
    fun solve(A: Int): String {

        val length =
            Math.ceil(Math.log(A + 2.0) / Math.log(2.0)).toInt() - 1
        val rank  = A - (1 shl length) + 1

        var left = ""
        var right = ""

        for (i in length - 1 downTo 0) {
            val mask = 1 shl i
            val bit = mask and rank

            if (bit > 0) {
                left += 1
                right += 1
            } else {
                left += 2
                right += 2
            }
        }

        val sb = StringBuilder(right)
        sb.reverse()

        right = sb.toString()

        return left + right
    }
}
package com.nichols.dsa.queues

class SlidingWIndowMaximum {
    fun slidingMaximum(A: IntArray, B: Int): IntArray? {
        val n = A.size
        val right = IntArray(n)
        val ans = ArrayList<Int>()
        right[n - 1] = n
        for (i in n - 2 downTo -1 + 1) {
            var p = i + 1
            while (p < n && A[p] <= A[i])
                p = right[p]

            right[i] = p
        }
        var i = 0
        var j = 0
        while (i <= n - B) {
            if (i > j) j = i
            while (right[j] < i + B)
                j = right[j]

            val m = if (j == n) A[i] else A[j]
            ans.add(m)

            i++
        }
        return ans.toIntArray()
    }
}
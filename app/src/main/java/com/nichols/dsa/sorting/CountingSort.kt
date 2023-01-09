package com.nichols.dsa.sorting

class CountingSort {
    fun countSort(A: IntArray): IntArray {
        //create frequency hashmap
        val max = A.maxOrNull()!!
        val min = A.minOrNull()!!
        val range = max - min + 1
        val cnt = IntArray(range)
        val res = IntArray(A.size)

        //create count of frequencies
        for (i in A.indices)
            cnt[A[i] - min]++

        //psum of frequencies
        for (i in 1 until cnt.size)
            cnt[i] += cnt[i - 1]

        for (i in A.indices.reversed()) {
            res[cnt[A[i] - min] - 1] = A[i]
            cnt[A[i] - min]--
        }

        //replace array with result at coorosponding index
        for (i in A.indices)
            A[i] = res[i]

        return A
    }
}
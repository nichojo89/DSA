package com.nichols.dsa.binary_search

fun solvesss(A:IntArray, B:Int): Int {
    val n = A.size
    var ans = n
    var sum = 0
    var start = 0

    for(end in A.indices)
    {
        sum += A[end]
        while (sum > B) {
            sum -= A[start]
            start++

            ans = Math.min(ans, end - start + 1)
            if (sum == 0)
                break
        }
        if (sum == 0)
        {
            ans = -1
            break
        }
    }
    return ans
}
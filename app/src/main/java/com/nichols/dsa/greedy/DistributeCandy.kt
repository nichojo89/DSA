package com.nichols.dsa.greedy

fun candy(A: IntArray): Int {
    val n = A.size
    var sum = 0
    val ans = IntArray(n)

    if (n == 1)
        return 1

    for (i in A.indices)
        ans[i] = 1

    for (i in 0 until n - 1) {
        if (A[i + 1] > A[i])
            ans[i + 1] = ans[i] + 1
    }

    for (i in n - 2 downTo 0) {
        if (A[i] > A[i + 1] && ans[i] <= ans[i + 1])
            ans[i] = ans[i + 1] + 1

        sum += ans[i]
    }
    sum += ans[n - 1]

    return sum
}
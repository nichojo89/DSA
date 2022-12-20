package com.nichols.dsa.modular_arithmatic

fun main(){
//    solveWeirdQuestionTwo(intArrayOf(5, 17, 100, 11 ),28)
}
fun findTrailingZeros(n: Int): Int {
    if (n < 0)
        return -1

    var count = 0

    // Keep dividing n by powers
    // of 5 and update count
    var i = 5
    while (n / i >= 1) {
        count += n / i
        i *= 5
    }
    return count
}
fun solve(a: IntArray, k: Int): Int {
    val n = a.size
    val mod = (1e9 + 7).toLong()
    val cnt = LongArray(k)

    for (x in a)
        cnt[x % k]++

    var ans = cnt[0] * (cnt[0] - 1) / 2
    var i = 1
    var j = k - 1
    while (i <= j) {
        ans = if (i == j) (ans + cnt[i] * (cnt[i] - 1) / 2) % mod else (ans + cnt[i] * cnt[j]) % mod
        i++
        j--
    }
    return ans.toInt()
}
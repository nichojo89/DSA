package com.nichols.dsa.recursion

private val res = ArrayList<IntArray>()

fun main(){
//    val ans = combine(4,2)
}
private var ans = arrayListOf<IntArray>()

fun combine(A: Int, B: Int): Array<IntArray> {
    ans = ArrayList()
    val cur = arrayListOf<Int>()
    solve(1, cur, A, B)
    return ans.toTypedArray()
}

fun solve(idx: Int, cur: ArrayList<Int>, A: Int, B: Int) {
    if (cur.size == B) {
        ans.add(cur.toIntArray())
        return
    }
    if (idx == A + 1)
        return

    // Include current element
    cur.add(idx)
    solve(idx + 1, cur, A, B)
    cur.remove(cur.size - 1)

    // Don't include current element
    solve(idx + 1, cur, A, B)
}
package com.nichols.dsa.backtracking

import java.util.*
import kotlin.collections.ArrayList

var ans: ArrayList<ArrayList<Int>>? = null
//fun solveSubSet(idx: Int, cur: ArrayList<Int?>, A: ArrayList<Int>) {
//    if (idx == A.size) {
//        ArrayList(cur)?.let { ans!!.add(it) }
//        return
//    }
//    solveSubSet(idx + 1, cur, A) // not take
//    val element = A[idx]
//    cur.add(element) // DO
//    solveSubSet(idx + 1, cur, A) // take
//    cur.remove(cur.size - 1) // UNDO
//}

//fun subsets(A: ArrayList<Int>): ArrayList<ArrayList<Int>> {
//    Collections.sort(A)
//    ans = ArrayList()
//    val cur: ArrayList<Int?> = ArrayList()
//    solveSubSet(0, cur, A)
//    // sort the list of list
//    Collections.sort(ans) { first: ArrayList<Int>, second: ArrayList<Int> ->
//        var i = 0
//        while (i < first.size && i < second.size) {
//            if (first[i] < second[i]) return@sort -1
//            if (first[i] > second[i]) return@sort 1
//            i++
//        }
//        if (first.size > second.size()) return@sort 1
//        -1
//    }
//    return ans.toTypedArray()
//}
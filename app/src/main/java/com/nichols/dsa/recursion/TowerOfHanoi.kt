package com.nichols.dsa.recursion

import java.util.*
import kotlin.collections.ArrayList

fun towerOfHanoi(A: Int): Array<IntArray> {
    val arr = ArrayList<IntArray>()
    val ans = TOH(A,1,2,3,arr)
    return ans.toTypedArray()
}

fun TOH(n: Int, A:Int, B:Int, C:Int, arr: ArrayList<IntArray>) : ArrayList<IntArray> {
    if(n > 0){
        TOH(n-1,A,C,B,arr)
        arr.add(intArrayOf(n,A,C))
        TOH(n-1,B,A,C,arr)
    }
    return arr
}

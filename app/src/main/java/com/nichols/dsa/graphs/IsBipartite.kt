package com.nichols.dsa.graphs

import java.util.*

fun combinationSum(A: IntArray, B: Int): Array<IntArray> {
    val res = mutableListOf<IntArray>()
    val temp = mutableListOf<Int>()
    val f = A.sorted().toIntArray()
//    helper(A.sorted(),B,0, temp, res)
    return res.toTypedArray()
}

fun helper(A: IntArray, target: Int, start: Int, temp : MutableList<Int>, results: MutableList<IntArray>){
    if(target == 0){
        results.add(temp.toIntArray())
        return
    }

    for(i in start until A.size){
        if(A[i]> target) break
        if(i > start && A[i] == A[i-1]) continue
        temp.add(A[i])
        helper(A, target-A[1],i,temp,results)
        temp.removeAt(temp.size-1)
    }
}
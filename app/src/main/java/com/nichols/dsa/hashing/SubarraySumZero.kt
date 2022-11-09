package com.nichols.dsa.hashing

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main(){
    solveZeroSum(intArrayOf(1, 2, 3, 4, 5))
}


@RequiresApi(Build.VERSION_CODES.N)
fun solveZeroSum(A: IntArray): Int {
    val mod = (1e9 + 7).toInt()
    val hm = hashMapOf<Long,Int>()
    var curr = 0L
    var ans = 0L
    hm[0L] = 1
    for (i in A.indices) {
        curr += A[i].toLong()
        if (hm.containsKey(curr)) {
            ans += hm[curr]!!
        }
        hm[curr] = hm.getOrDefault(curr,0)+ 1
    }
    return (ans % mod).toInt()
//    val psum = LongArray(A.size)
//    //create prefix sum
//    for(i in A.indices)
//        if(i != 0)
//            psum[i] = A[i] + psum[i-1]
//        else
//            psum[i] = A[i].toLong()
//
//    val hs = hashSetOf<Long>()
//    for(i in psum){
//        if(i == 0L)
//            return 1
//
//        hs.add(i)
//    }
//    return if(hs.size != A.size) 1 else 0
}
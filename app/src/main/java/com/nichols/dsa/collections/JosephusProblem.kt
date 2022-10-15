package com.nichols.dsa.collections

import java.util.Collections.copy

fun main(){
//    val f = solve(100)
//    if(f == 73){
//        val G = 0
//    }
    //expected 73
    maxPositivity(intArrayOf(8986143, -5026827, 5591744, 4058312, 2210051, 5680315, -5251946, -607433, 1633303, 2186575))
}
fun maxPositivity(A: IntArray): IntArray {
    val l = arrayListOf<Int>()
    var w = intArrayOf()

    for(i in A.indices){
        if(A[i] > 0)
        {
            l.add(A[i])
            if(l.size > w.size )
                w = l.toIntArray()
        }
        else
            l.clear()
    }
    return w.toTypedArray().toIntArray()
}
fun solve(A: Int): Int {
    //find highest power of 2
    var j = 1
    var cont = true
    while (cont){
        if((j * 2) > A){
            cont = false
        } else {
            j *= 2
        }
    }
    val kills = A - j
    var winner = 1
    for(k in 0 until kills){
        if(k == 34){
            val G = 0
        }
        winner += 2
    }
    return winner
}
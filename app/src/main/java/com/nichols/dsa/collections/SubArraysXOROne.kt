package com.nichols.dsa.collections

fun main(){
    val s = solveSubXORSum(2, intArrayOf(1,0))
    val f = 0
}
fun solveSubXORSum(A: Int, B: IntArray): Long {
    return ((A*(A+1)/2)-1).toLong()
}
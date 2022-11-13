package com.nichols.dsa.recursion


fun solve(A: Int): Int =  recursiveSum(A,0)

fun recursiveSum(A: Int, B : Int): Int {
    if(B >= A.toString().length){
        return 0
    }

    val g = "$A"[B].toString().toInt()
    return g + recursiveSum(A,B+1)
}
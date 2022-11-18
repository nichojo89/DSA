package com.nichols.dsa.recursion

fun main(){
    solveMagicNumber(12345)
    val A = 12345
    val g = solveMagicRecursive(A,A)
}

fun solveMagicRecursive(A: Int, B: Int): Int{
    if(A.toString().length == 1)
        return if(A == 1) 1 else 0

    val f = B.toString().map { it.digitToInt() }.sum()
    return solveMagicRecursive(f,A)
}
fun solveMagicNumber(A: Int): Int {
    var ans = A
    while(ans.toString().length != 1){
        val f = ans.toString().map { it.digitToInt() }
        ans = f.sum()
    }

    return if(ans == 1) 1 else 0
}
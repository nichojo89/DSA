package com.nichols.dsa.sorting

fun main(){

}
fun solve(A: IntArray): Int {
    A.sortDescending()
    var cost = 0
    for(i in A.indices){
        cost += (A[i] * (i+1))
    }

    return cost
}
package com.nichols.dsa.sorting

fun main(){
    val ans = solveUniqueElements(intArrayOf(5,3,4,5,6,5))
}
fun solveUniqueElements(A: IntArray): Int {
    A.sort()
    var count = 0
    for(i in 0 until A.size-1){
        var left = A[i]
        var right = A[i+1]
        if(left == right) {
            A[i+1] = right+1
            count++
        } else if(left > right){
            val new = left+1
            A[i+1] = new
            count += new - right
        }
    }
    return count
}
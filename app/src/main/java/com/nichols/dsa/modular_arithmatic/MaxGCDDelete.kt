package com.nichols.dsa.modular_arithmatic

fun main(){
    val g = solveDelete(intArrayOf(3, 9, 6, 8, 3))
    
}
fun solveDelete(A: IntArray): Int {
    //create prefix sum of gcd from left to right
    val left = IntArray(A.size)
    left[0] = A[0]
    for(i in 1 until A.size){
        left[i] = gcd(left[i-1],A[i])
    }

    //create prefix sum of gcd from right to left
    val right = IntArray(A.size)
    right[A.size-1] = A[A.size-1]
    for(i in A.size-2 downTo 0){
        right[i] = gcd(right[i+1], A[i])
    }

    var m = gcd(left[0],right[1])
    for(i in 1 until A.size-1){
        m = Math.max(left[i-1], right[i+1])
    }
    return m
}

fun gcd(A: Int, B: Int): Int{
    if(B == 0)
        return A

    return gcd(B,A%B)
}
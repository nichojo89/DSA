package com.nichols.dsa.sorting

fun main(){
    val result = solveBB(intArrayOf(36, 13, 13, 26, 37, 28, 27, 43, 7))
    val int = 0
}
fun solveBB(A: IntArray): IntArray {
    val fact = IntArray(10001)
    for(i in 0..10000)
        fact[i] = getFactorCount(i)

    for(i in 0 until A.size-1)
        for(j in 0 ..A.size-2)
            if(factoralComparator(A[j],A[j+1], fact) > 0)
                swapTwo(j, A)

    return A
}

fun factoralComparator(A: Int, B: Int, C: IntArray): Int{
    val aFactorCount = C[A]
    val bFactorCount = C[B]

    if(aFactorCount < bFactorCount)
        return -1
    else if(aFactorCount == bFactorCount && A < B)
        return 0
    else
        return 1
}

fun getFactorCount(A: Int) : Int {
    var count = 0
    for(i in 1 .. A)
        if(A % i == 0)
            count++
    return count
}

/**
 * Swaps two elements in an array
 */
fun swapTwo(a: Int, c: IntArray){
    val b = a+1
    val d = c[a]
    c[a] = c[b]
    c[b] = d
}
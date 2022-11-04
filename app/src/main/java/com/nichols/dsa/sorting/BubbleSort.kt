package com.nichols.dsa.sorting

fun main(){
    val result = bubbleSort(intArrayOf(2,5,7,3,6,8,8,9,3,3))
    val int = 0
}
fun bubbleSort(A: IntArray): IntArray {
    try {
        for(i in 1 until A.size-1)
            for(j in 0..A.size-2)
                if(lessThanComparator(A[j],A[j+1]))
                    swap(j, A)
    } catch (e: java.lang.Exception){
        val g = 0
    }
    return A
}

/**
 * returns 1 if a less than b
 */
fun lessThanComparator(a: Int, b: Int) : Boolean = a > b

/**
 * Swaps two elements in an array
 */
fun swap(a: Int, c: IntArray){
    val b = a+1
    val d = c[a]
    c[a] = c[b]
    c[b] = d
}
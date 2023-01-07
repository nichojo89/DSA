package com.nichols.dsa.sorting

fun main(){
    val test = intArrayOf(1,4,6,8,5,3,3,34,5,6,7,6,6,67,8,8,6,4,3,3,34,5,67,8,4,8)
    mergeSort(test)
    val g =0
}

/**
 * O(n log n)
 */
fun mergeSort(A: IntArray){
    val n = A.size

    if(n < 2)
        return

    val mid = n/2
    val left = IntArray(mid)
    val right = IntArray(n - mid)
    for(i in 0 until mid)
        left[i] = A[i]
    for(j in mid until n)
        right[j - mid] = A[j]

    mergeSort(left)
    mergeSort(right)
    merge(A,left,right)
}
fun merge(A: IntArray,L: IntArray, R: IntArray){
    val lSize = L.size
    val rSize = R.size
    var i = 0
    var j = 0
    var k = 0

    while(i < lSize && j < rSize){
        if(L[i] <= R[j]){
            A[k] = L[i]
            i++
        } else {
            A[k] = R[j]
            j++
        }
        k++
    }

    while(i < lSize){
        A[k] = L[i]
        i++
        k++
    }

    while(j < rSize){
        A[k] = R[j]
        j++
        k++
    }
}
package com.nichols.dsa.modular_arithmatic

import java.util.*

fun findNumbers(A: IntArray, n: Int) : IntArray {
    val n = A.size
    // Sort in decreasing order
    Arrays.sort(A)
    reverse(A)
    val f = IntArray(A[0] + 1)

    // Count frequency of each element
    for (i in 0 until n) {
        f[A[i]]++
    }

    // Size of the resultant array
    val size = Math.sqrt(n.toDouble()).toInt()
    val brr = IntArray(size)
    var x: Int
    var l = 0
    for (i in 0 until n) {
        if (f[A[i]] > 0 && l < size) {

            // Store the highest element in
            // the resultant array
            brr[l] = A[i]

            // Decrement the frequency of that element
            f[brr[l]]--
            l++
            for (j in 0 until l) {
                if (i != j) {

                    // Compute GCD
                    x = gcd(A[i], brr[j])

                    // Decrement GCD value by 2
                    f[x] -= 2
                }
            }
        }
    }
    return brr
}

//fun gcd(A: Int, B: Int): Int {
//    if(B==0)
//        return A
//
//    return gcd(B,A%B)
//}

fun reverse(B: IntArray): IntArray {
    val A = B
    var i = 0
    var j = A.size-1
    while(i < j){
        var t = A[i]
        A[i] = A[j]
        A[j] = t
        i++
        j--
    }

    return A
}
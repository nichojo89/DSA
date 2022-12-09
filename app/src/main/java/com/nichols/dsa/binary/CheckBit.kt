package com.nichols.dsa.binary

fun numSetBits(A: Int): Int {
    var A = A
    var ones = 0
    while (A != 0) {
        A = A and A - 1
        ones++
    }
    return ones
}
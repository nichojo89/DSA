package com.nichols.dsa.binary

fun singleNumber(A: IntArray): Int {

    var ans = 0
    for(i in A){
        ans = ans xor i
    }
    return ans
}
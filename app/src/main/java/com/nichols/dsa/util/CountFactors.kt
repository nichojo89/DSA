package com.nichols.dsa.util

fun main() {
    val a = getFactorsForNumber(49)
    //3
}

/**
 * Optimized code to get factors for an Integer
 */
fun getFactorsForNumber(A: Int): Int {
    var factors = 0
    var i = 1
    while(i * i <= A){
        if(A % i == 0){
            if(i == A/i){
                factors++
            } else {
                factors += 2
            }
        }
        i++
    }

    return factors
}
package com.nichols.dsa.util

fun main() {
    val a = getFactorsForNumber(49)
    //3
}

/**
 * Optimized code to get factors for an Integer
 */
fun getFactorsForNumber(A: Int): Int {
    val sqaureRoot = Math.sqrt(A.toDouble())
    val flooredSqaureRoot = Math.floor(sqaureRoot)

    return if(sqaureRoot == flooredSqaureRoot)
        sqaureRoot.toInt()
    else
        -1
}
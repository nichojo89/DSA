package com.nichols.dsa.sorting

fun main(){
    val f = charArrayOf('S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0' )
    val r = solveIsStringAlphaNumeric(f)
    val h = 0
}



fun solveIsStringAlphaNumeric(A: CharArray): Int {
    for(c in A){
        if((c >= 65.toChar() && c <= 90.toChar())
            || c >= 97.toChar() && c <= 122.toChar()
            || c >= 48.toChar() && c <= 57.toChar()
        ){

        } else {
            return 0
        }
    }
    return 1
}
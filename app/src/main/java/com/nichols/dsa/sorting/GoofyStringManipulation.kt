package com.nichols.dsa.sorting

fun main() {
    val r = solve("AbcaZeoB")
    val g = 0
    //bc###bc###
}
fun solveGoofy(A: String): String {
    var ans = ""
    for(c in A.indices){
        if(A[c] >= 65.toChar() && A[c] <= 90.toChar()){
            //delete uppercase
            //do nothing, we dont want to add this to our new string
        } else {
            //replace each vowel with #
            when(A[c]){
                'a','e','i','o','u' -> ans += '#'
                else -> {
                    if(A[c] >= 97.toChar() && A[c] <= 122.toChar())
                        ans += A[c]
                }
            }
        }
    }
    //repeat
    return "$ans$ans"
}
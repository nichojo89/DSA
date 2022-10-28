package com.nichols.dsa.collections
fun main(){
    val ans = solveInteresting(intArrayOf(9, 17))
}
fun solveInteresting(A: IntArray): String {
    var count = 0
    for(num in A){
        if(num % 2 != 0)
            count++
    }
    if(count % 2 != 0)
        return "No"
    else
        return "Yes"
}
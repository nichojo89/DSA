package com.nichols.dsa.prime

fun main(){
    val ans = solveLuckyNumber(12)
}
fun solveLuckyNumber(A: Int): Int {
    //create seive
//    val seive = BooleanArray(A+1){true}
    val seive = IntArray(A+1)
//
//    seive[0] = false
//    seive[1] = false

    var p = 2
    while(p<=A){
        if(seive[p] == 0){
            var i = p+p
            while(i <= A){
                seive[i]++
                i += p
            }
        }
        p++
    }

    var ans = 0
    for(i in seive){
        if(i == 2)
            ans++
    }
    return ans
}
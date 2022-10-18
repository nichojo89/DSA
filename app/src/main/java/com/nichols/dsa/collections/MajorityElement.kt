package com.nichols.dsa.collections

fun main(){
    val f = listOf(1, 1, 1, 2, 3, 5, 7)
    N3Question().repeatedNumber(f)
}
fun majorityElement(A: IntArray): Int {
    var freq = 1
    var ele = A[0]
    //identify majority element
    for(i in 1 until A.size){
        if(freq == 0){
            ele = A[i]
            freq = 1
        } else if(A[i] == ele){
            freq++
        } else {
            freq--
        }
    }

//count the majority elements
//var count = 0
//for(i in A){
//    if(i == ele)
//        count++
//}

return ele
}
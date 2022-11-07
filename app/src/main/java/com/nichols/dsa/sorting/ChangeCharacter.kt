package com.nichols.dsa.sorting

fun main(){
//    val f = solveChangeCharacter("abcabbccd", 3)
//    val two = 0
    val six = solveBobCount("bobbobbob a ba bobo boboranbobo")
    val r = solveBobCount("")
}
fun solveBobCount(A: String?): Int {
    if(A!!.length < 3)
        return 0

    //count the bobs
    var count = 0
    for(i in 0..A.length-3){
        val b = 'b'
        val o = 'o'
        if(A[i] == b
            && A[i+1] == o
            && A[i+2] == b){
            count++
        }
    }
    return  count
}
fun solveChangeCharacter(A: String, B: Int): Int {
    //calculate frequencies
    val count = IntArray(26)
    for(i in A.indices){
        val idx = A[i] - 'a'
        count[idx] += 1
    }

    val c = arrayListOf<Int>()
    for(i in 0..26){
        if(count[i] > 0)
            c.add(count[i])
    }
    c.sort()
    var b = B
    for(i in c.indices){
        b -= c.get(i)
        if(b < 0)
            return c.size -1
    }

    return 1
}
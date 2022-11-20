package com.nichols.dsa.hashing

fun main(){
//    val r = colorful(3245)
    val g = colorful(2634)
}
fun colorful(A: Int): Int {
    //Get all sub arrays for int O(n^2) style
    val allSubArrays = arrayListOf<IntArray>()
    val B = A.toString().map { it.digitToInt() }.toIntArray()
    for(i in B.indices){
        for(j in i until B.size){
            val sub = arrayListOf<Int>()
            for(k in i..j){
                sub.add(B[k])
            }
            allSubArrays.add(sub.toIntArray())
        }

    }
    val hs = hashSetOf<Int>()
    //for each subarray
    for(arr in allSubArrays){
        var s = 1
        for(n in arr)
            s *= n

        if(hs.contains(s))
            return 0
        else
            hs.add(s)
    }
    return 1
}


fun generateAllSubArrays(A: IntArray){
    val r = arrayListOf<IntArray>()
    for(i in A.indices){
        for(j in i until A.size){
            val sub = arrayListOf<Int>()
            for(k in i..j){
                sub.add(A[k])
            }
            r.add(sub.toIntArray())
        }

    }
    val g = 0
}
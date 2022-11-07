package com.nichols.dsa.sorting


fun main(){

    val ab = longestCommonPrefix(arrayOf("ABCD"))
    val f = 0
}
fun longestCommonPrefix(A: Array<String>): String {
    val count = IntArray(26)
    val freqArray = Array(A.size){IntArray(26)}

    for(i in A.indices){
        //populate freq array
        for(j in A[i].indices){
            val idx = A[i][j] - 'a'
            freqArray[i][idx] += 1
        }
    }
    var prefix = ""
    //for each char
    for(i in 0 until 26){
        //does each array have char
        var hasChar = true
        for(arr in freqArray){
            if(arr[i] == 0)
                return prefix
        }
        //add char to answer string
        prefix += 'a' + i
    }

    return prefix
}


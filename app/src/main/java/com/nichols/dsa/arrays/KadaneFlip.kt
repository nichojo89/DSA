package com.nichols.dsa.arrays

fun main(){
val ans = flip("010")
}

fun flip(A: String): IntArray {
    val arr =  arrayListOf<Int>()
    for(c in A){
        if(c == '1')
            arr.add(-1)
        else
            arr.add(1)
    }
    var curr = 0
    var best = 0
    var l = 0
    var r = -1
    var idx = 0
    for(i in arr.indices){
        curr += arr[i]
        if(curr < 0){
            curr = 0
            idx = i+1
        } else if(curr > best){
            //new best
            l = idx
            r = i
            best = curr
        }
    }

    return if(r != -1) intArrayOf(l+1,r+1) else intArrayOf()
}
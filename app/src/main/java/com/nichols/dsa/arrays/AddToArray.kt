package com.nichols.dsa.arrays

fun main () {
    val ans4 = plusOne(intArrayOf(0))
    val ans1 = plusOne(intArrayOf(0,7,2,4))
    val ans2 = plusOne(intArrayOf(7,2,4))
    val ans3 = plusOne(intArrayOf(9,9,9))
}

//-1 + -5 + -15 + 9
fun plusOne(A: IntArray): IntArray {
    var isLeadingWithZeros = true
    val arr = arrayListOf<Int>()
    //remove leading zeros
    for(i in A.indices){
        if(isLeadingWithZeros)
            if(A[i] == 0){
                continue
            } else {
                isLeadingWithZeros = false
            }

        arr.add(A[i])
    }
    //edge case
    if(arr.size == 0)
        arr.add(0)
    //reverse array
    arr.reverseArray()
    //add 1
    var addTerm = false
    for(i in arr.indices){
        if(arr[i] == 9) {
            arr[i] = 0
            addTerm = true
        }
        else {
            addTerm = false
            arr[i]++
            break
        }
    }
    if(addTerm)
        arr.add(1)
    //reverse back
    arr.reverseArray()
    return arr.toIntArray()
}

fun ArrayList<Int>.reverseArray() {
    val A =this
    var s = 0
    var e = A.size-1
    while(s < e){
        //swap
        val t = A[s]
        A[s] = A[e]
        A[e] = t
        s++
        e--
    }
}
package com.nichols.dsa.hashing
fun main(){
    dNums(intArrayOf(31, 51, 31, 51, 31, 31, 31, 31, 31, 31, 51, 31, 31),
        3)
}
fun dNums(A: IntArray, B: Int): IntArray {
    //Handle edge case
    if(B== 1){
        for(i in A.indices)
            A[i] = 1
        return A
    }

    val hm = hashMapOf<Int,Int>()
    //insert 1st B elements into hashmap
    for(i in 0 until B){
        if(hm.containsKey(A[i]))
            hm[A[i]] = hm[A[i]]!! + 1
        else
            hm[A[i]] = 1
    }

    //sliding window
    var s = 1
    var e = B
    val n = A.size
    val ans = arrayListOf<Int>()
    ans.add(hm.size)

    while(e < n){
        val ss = A[s-1]
        val ee = A[e]
        //decrement A[s-1] out of sliding window
        if(hm.containsKey(A[s-1]))
            hm[A[s-1]] = hm[A[s-1]]!!-1

        //if theres not more occurrences of A[s-1], remove it
        if(hm[A[s-1]]==0)
            hm.remove(A[s-1])

        //add or update end
        if(hm.containsKey(A[e]))
            hm[A[e]] = hm[A[e]]!!+1
        else
            hm[A[e]] = 1

        //size == distinct elements
        ans.add(hm.size)

        s++
        e++
    }
    return ans.toIntArray()
}
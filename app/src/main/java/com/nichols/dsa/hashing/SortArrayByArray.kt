package com.nichols.dsa.hashing

fun main(){
    val ans = solvessssss(intArrayOf(1, 2, 3, 4, 5), intArrayOf(5,4,2))
}
fun solvessssss(A: IntArray, B: IntArray): IntArray {
    val hm = hashMapOf<Int,Int>()
    val ans = arrayListOf<Int>()

    //create frequency map
    for(i in A.indices)
        if(hm.containsKey(A[i]))
            hm[A[i]] = hm[A[i]]!!+1
        else
            hm[A[i]] = 1

    for(i in B.indices){
        if(hm.containsKey(B[i])){
            val n = hm[B[i]]!!
            for(j in 0  until  n)
                ans.add(B[i])
            hm.remove(B[i])
        }
    }

    val sorted = hm.toSortedMap()

    for(i in sorted.keys){
        for(j in 0 until sorted[i]!!)
            ans.add(i)
    }


    return ans.toIntArray()
}
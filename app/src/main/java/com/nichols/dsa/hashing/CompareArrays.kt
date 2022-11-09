package com.nichols.dsa.hashing

fun main(){
    val g = solveCommonElements(intArrayOf(1, 2, 2, 1), intArrayOf(2, 3, 1, 2))
    val k =0
}
fun solveCommonElements(A: IntArray, B: IntArray): IntArray {
    val ahs = hashMapOf<Int,Int>()
    for(i in A.indices)
        if(ahs.containsKey(A[i]))
            ahs[A[i]] = ahs[A[i]]!! + 1
        else
            ahs[A[i]] = 1

    val bhs = hashMapOf<Int, Int>()
    for(i in B.indices)
        if(bhs.containsKey(B[i]))
            bhs[B[i]] = bhs[B[i]]!! + 1
        else
            bhs[B[i]] = 1

    val result = mutableListOf<Int>()
    //iterate the smallest hashset
    if(Math.max(ahs.size,bhs.size) == ahs.size){
        //bhs is smallest, use that!
        for(i in bhs.keys){
            if(ahs.containsKey(i)){
                //match
                val matchCount = Math.min(ahs[i]!!,bhs[i]!!)
                for(j in 0 until matchCount)
                    result.add(i)
            }
        }
    } else {
        for(i in ahs.keys){
            if(bhs.containsKey(i)){
                //match again
                val matchCount = Math.min(ahs[i]!!,bhs[i]!!)
                for(j in 0 until matchCount)
                    result.add(i)
            }
        }
    }
    return result.toIntArray()
}
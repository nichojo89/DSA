package com.nichols.dsa.twopointer
fun main(){
    val ans = solvePairSum(intArrayOf(2, 3, 5, 6, 10 ),6)
}
/**
 * Count of how many pair sums == B
 */
fun solvePairSum(A: IntArray, B: Int): Int {
    var ans = 0L
    val hm = hashMapOf<Int,Int>()
    for(i in A.indices)
       if(hm.containsKey(A[i]))
           hm[A[i]] = hm[A[i]]!!+1
        else
            hm[A[i]] = 1
    for(i in A.indices){
        hm[A[i]] = hm[A[i]]!!-1
        val g = B - A[i]
        if(hm.containsKey(hm[g]))
            ans += hm[g]!! % (1e9 + 7).toInt()

        if(hm.containsKey(A[i]))
            hm[A[i]] = hm[A[i]]!!+1
        else
            hm[A[i]] = 1
    }
    ans /= 2

    return ans.toInt()
}


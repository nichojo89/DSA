package com.nichols.dsa.arrays
fun main(){
    val A = arrayOf(intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9))

    val B = 2
    val ans = solveQuery(A,B)
}
fun solveQuery(A: Array<IntArray>, B: Int): Int {
    var ans = Integer.MAX_VALUE
    for(i in A.indices)
        for(j in A[i].indices)
            if(A[i][j] == B){
                ans = Math.min(ans, (i+1) * 1009 + (j+1))
            }

    return ans
}
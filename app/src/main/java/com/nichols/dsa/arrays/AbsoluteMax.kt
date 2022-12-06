package com.nichols.dsa.arrays

fun main(){
    val A = intArrayOf(1, 2, 3, 4)
    val B = intArrayOf(-1, 4, 5, 6)
    val C = intArrayOf(-10, 5, 3, -8)
    val D = intArrayOf(-1, -9, -6, -10)
    val ans = solveAbsMax(A,B,C,D)
}
fun solveAbsMax(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
    val n = A.size
    var res = 0
    for(i in 0 until 16){
        var maxi = Integer.MIN_VALUE
        var mini = Integer.MAX_VALUE
        for(j in 0 until n){
            var cur = A[j]
            for(k in 0 until 4){
                val temp = when(k){
                    1 -> B[j]
                    2 -> C[j]
                    3 -> D[j]
                    else -> j
                }

                if(i and (1 shl k) == 0)
                    cur += temp
                else
                    cur -= temp
            }
            maxi = Math.max(maxi,cur)
            mini  = Math.min(mini,cur)
        }
        res = Math.max(res, maxi - mini)
    }
    return res
}

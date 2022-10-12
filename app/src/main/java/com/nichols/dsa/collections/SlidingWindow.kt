package com.nichols.dsa.collections

fun main(){
    val a = intArrayOf(6, 3, 3, 6, 7, 8, 7, 3, 7)
    val b = 2
    val c = 10
    solve(a,b,c)
}

/**
 * idea 1 O(k (n-k+1))
 * idea 2 t.c = O(n), s.c = O(n)
 * idea 3, sliding window, t.c = O(n) s.c = O(1)
 */
fun solve(A: IntArray, B: Int, C: Int): Int {
    val N = A.size
    var ans = Integer.MIN_VALUE

    //idea 3 - Sliding Window
    var sum = 0
    for(i in 0 until B)
        sum += A[i]

    ans = sum
    var s = 1
    var e = B

    //idea 1 & 2
    //var s = 0
    //var e = B-1

    //idea 2 - calculate prefix sum
//    for(i in A.indices)
//        if(i != 0)
//            A[i] = A[i-1] + A[i]

    //until then end index has reached end
    while(e < N){
        sum = sum - A[s-1] + A[e]
        //idea 1
//        for(i in s..e){
//            sum += A[i]
//        }
        //idea 2
//        if(s == 0)
//            sum = A[e]
//        else
//            sum = A[e] - A[s-1]

        if(sum == C){
            return 1
        }
        //slide one over
        s++
        e++
    }

    return 0
}
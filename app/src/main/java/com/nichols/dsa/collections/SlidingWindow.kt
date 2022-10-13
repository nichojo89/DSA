package com.nichols.dsa.collections

fun main(){
    val a = intArrayOf(1, 12, 10, 3, 14, 10, 5)
    val b = 8
    minimumSwaps(a,b)
}

fun minimumSwaps(A: IntArray, B: Int): Int {
    //count # of good elements
    var k = 0
    for(num in A)
        if(num < B)
            k++
    //return zero for unswapables
    when(k) {0,1 -> return 0 }

    var bad = 0
    //get first window
    for(i in 0..k)
        if(A[i] > B)
            bad++

    //apply sliding window
    var ans = bad
    var s = 1
    var e = k
    while(e < A.size-1){
        if(A[s-1] > B)
            bad--
        if(A[e] > B)
            bad++
        if(bad < ans)
            ans = bad

        s++
        e++
    }
    return ans
}

/**
 * idea 1 O(k (n-k+1))
 * idea 2 t.c = O(n), s.c = O(n)
 * idea 3, sliding window, t.c = O(n) s.c = O(1)
 */
fun findNumInSlidingWindow(A: IntArray, B: Int, C: Int): Int {
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
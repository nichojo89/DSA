package com.nichols.dsa.hashing

fun main(){

    val seriosly = solveSubSumTwo(intArrayOf(-2, 16, -12, 5, 7, -1, 2, 12, 11 ),
        17)
}

fun solvePairSum(A: IntArray, B: Int): Int {
    val hs = hashMapOf<Int,Int>()
    //?
    hs[0] = 1
    var currSum = 0
    var ans = 0
    for (i in A.indices) {
        currSum += A[i]
        if (hs.containsKey(currSum - B)) {
            ans += hs[currSum - B]!!
        }
        //
        var x = 0
        if(hs.containsKey(currSum))
            x = hs[currSum]!!

        hs[currSum] = x + 1
    }
    return ans
}
fun solveDYING(A: IntArray, B: Int): Int {
    var count = 0
    for(i in A.indices){
        for(j in i..A.size-1){
            val s = A.copyOfRange(i,j).sum()
            if(s == B)
                count++
        }
    }

    return count
}

fun solveSubSumTwo(A: IntArray, B: Int): Int {
    val n = A.size
    var s = A[0]
    var left = 0
    var right: Int
    var count = 0

    right = 1
    while (right <= n) {
        //shrink
        while (s > B && left < right) {
            val l = A[left]
            if(l < 0)
                s += l
            else
                s -= l

            left++
        }

        //winner
        if (s == B) {
            count++
        }

        //expand
        if (right < n)
            s += A[right]

        right++
    }

    return count
}
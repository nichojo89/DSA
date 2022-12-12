package com.nichols.dsa.binary

fun solveSubOr(A: IntArray): Int {
    val n = A.size
    val idx = IntArray(32)
    var ans: Long = 0

    for (i in 1..n) {

        val tmp = A[i - 1].toLong()
        for (j in 0..31) {
            //if jth bit is set
            val pw = (1 shl j).toLong()
            if (tmp and pw != 0L) {
                // add its contribution
                ans += pw * i
                // store the index for next elements
                idx[j] = i
            } else if (idx[j] != 0)
                ans += pw * idx[j]
        }
    }
    return (ans % 1000000007).toInt()
}

fun solveMaxAndPair(A: IntArray): Int {
    var B = A
   for(i in 31 downTo 0){
       var C = arrayListOf<Int>()
       for(j in B.indices){
           //check bit
           if(((B[j] shr i) and 1) > 0)
               C.add(B[j])
       }

       if(C.size >= 2)
           B = C.toIntArray()
   }

    return B[0] and B[1]
}

fun solve(A: IntArray): IntArray {
    var sum = 0
    for(i in A.indices)
        sum = (sum xor A[i])

    sum = (sum and -sum)

    var sum1 = 0
    var sum2 = 0

    for(i in A.indices)
        if((A[i] and sum) > 0)
            sum1 = (sum1 xor A[i])
        else
            sum2 = (sum2 xor A[i])
    return intArrayOf(sum1,sum2).sortedArray()
}
package com.nichols.dsa.hashing

fun main(){
    //val two = solveZeroSums(intArrayOf(9, -20, -11, -8, -4, 2, -12, 14, 1))
    val two = solveZeroSums(intArrayOf(-16, 16, 3))
}

fun solveZeroSums(A: IntArray): Int {
    val prefixHm = hashMapOf<Int,Int>()
    var cf = A[0]
    var length = 0
    //create prefix
    for(i in A.indices){
        if(i == 0){
            prefixHm[A[i]] = i
        }
        else{
            cf += A[i]
            if(prefixHm.containsKey(cf)
                && prefixHm[cf]!! > length)
                if(prefixHm[cf]!! == 0)
                    length = i+1
                else
                    length = i - prefixHm[cf]!!
            else
                prefixHm[cf] = i
        }
    }

    return length
}

fun solve(A: IntArray): Int {
    val prefixHm = hashMapOf<Int,Int>()
    var length = 0
    for(i in A.indices)
        if(i == 0)
            prefixHm[A[i]] = i
        else if(prefixHm.contains(A[i])
            && i - prefixHm[A[i]]!! > length)
            length = i - prefixHm[A[i]]!!
        else
            prefixHm[A[i-1] + A[i]] = i
    return length
}

fun solveLongSubArraySum(A: IntArray, B: Int): Int {
    var ans = Integer.MAX_VALUE
    for(i in A.indices){
        val a = A[i]
        val b = B-a
        for(j in i+1 until A.size)
            if(A[j] == b && j-i < ans)
                ans = j-i
    }
    return ans
}

fun solvesdf(A: IntArray): Int {
    val hM = HashMap<Long, Int>()
    var sum = 0L
    var maxLength = 0

    for (i in A.indices) {
        //carryforward sum
        sum += A[i]
        if (sum == 0L)
            maxLength = i + 1

        val prev_i = hM[sum]
        //if sum exists then length equals last occurange's index minus current index
        if (prev_i != null)
            maxLength = Math.max(maxLength, i - prev_i)
        else
        //add prefix sum index to hashmap
            hM[sum] = i
    }
    return maxLength
}
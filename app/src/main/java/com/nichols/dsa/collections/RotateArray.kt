package com.nichols.dsa.collections

fun main(){
    val a = intArrayOf(1, 2, 3, 4, 5)
    val b = intArrayOf(2,3)
    //val c = solveRotateArray(a,b)
    //solveSpecialIndex(intArrayOf(1,1,1))

    val d = intArrayOf(1,2,3,4,5)
    val e = arrayOf(
        intArrayOf(0,2),
        intArrayOf(1,4)
    )
    solveQueryEvens(d,e)
}
fun solveRotateArray(A: IntArray, B: IntArray): Array<IntArray> {
    val arr =  arrayListOf<IntArray>()

    for(s in B){
        val sub = IntArray(A.size)
        var shift = s
        //Only one iteration required
        if(shift  > A.size)
            shift %= A.size

        A.forEachIndexed { index, i ->
            val newIndex = (index + (A.size - shift)) % A.size
            sub[newIndex] = i
        }
        arr.add(sub)
    }
    return arr.toTypedArray()
}


fun solveSpecialIndex(A: IntArray): Int {
    val n = A.size
    var count = 0
    val evenPrefixSum = IntArray(n)
    val oddPrefixSum = IntArray(n)

    //Create prefix sum arrays for all odds and evens
    for(i in A.indices){
        if(i % 2 == 0){
            if(i == 0){
                oddPrefixSum[i] = 0
                evenPrefixSum[i] = A[i]
            } else {
                evenPrefixSum[i]  = evenPrefixSum[i-1] + A[i]
                oddPrefixSum[i] = oddPrefixSum[i-1]
            }
        } else {
            oddPrefixSum[i] = oddPrefixSum[i-1] + A[i]
            evenPrefixSum[i] = evenPrefixSum[i-1]
        }
    }

    for(i in A.indices){
        var even = oddPrefixSum[n-1] - oddPrefixSum[i]
        if(i != 0)
            even += evenPrefixSum[i-1]

        var odd = evenPrefixSum[n-1] - evenPrefixSum[i]
        if(i != 0)
            odd += oddPrefixSum[i-1]

        if(even == odd)
            count++
    }

    //Brute force approach
//    for(i in A.indices){
//        val arr = arrayListOf<Int>()
//        for(j in A.indices){
//            if(j != i){
//                arr.add(A[j])
//            }
//        }
//        var evenSum = 0
//        var oddSum = 0
//        arr.forEachIndexed { index, elem ->
//            if(index % 2 == 0)
//                evenSum += elem
//            else
//                oddSum += elem
//        }
//        if(oddSum == evenSum)
//            count++
//    }
    return count
}

fun solveQueryEvens(A: IntArray, B: Array<IntArray>): IntArray {
    val evenPrefix = IntArray(A.size)
    val oddPrefix = IntArray(A.size)
    //populate prefix arrays
    for(i in A.indices){
        if(i % 2 == 0){
            if(i == 0){
                evenPrefix[0] = A[i]
            } else {
                oddPrefix[i] = oddPrefix[i-1]
                evenPrefix[i] = evenPrefix[i-1] + A[i]
            }
        } else {
            oddPrefix[i] = oddPrefix[i-1] + A[i]
            evenPrefix[i] = evenPrefix[i-1]
        }
    }
    val results = IntArray(B.size)

    for(k in B.indices){
        val start = B[k][0]
        val end = B[k][1]

        if(start == 0)
            results[k] = evenPrefix[end]
        else
            results[k] = evenPrefix[end] - evenPrefix[start-1]
    }

    return results
}

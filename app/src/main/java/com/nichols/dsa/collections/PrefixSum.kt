package com.nichols.dsa.collections


fun main(){
    val a = intArrayOf(7,10)
    val b = intArrayOf(3,10)
    val c = intArrayOf(3,5)
    val e = intArrayOf(1,10)
    val q: Array<IntArray> = arrayOf(a,b,c,e)

    val d = intArrayOf(7, 3, 1, 5, 5, 5, 1, 2, 4, 5 )
    val z = rangeSum(d,q)
    printSums(z)
}


/**
 * O(nq) ~ Returns query results for a range of queries
 */
fun rangeSum(A: IntArray, B: Array<IntArray>): LongArray {
    //calculate prefix sum O(n)
    for(i in A.indices)
        if(i != 0)
            A[i] = A[i-1] + A[i]

    val r = ArrayList<Long>()
    var q = 0

    //O(q) ~ for each query
    while(q < B.size){

        val query = B[q]
        val leftIndex = query[0] - 1
        val rightIndex = query[1] - 1

        val sum = when (leftIndex) {
            0 -> A[rightIndex]
            else -> A[rightIndex] - A[leftIndex - 1]
        }

         r += sum.toLong()
        q++
        //27
        //38
    }
    return r.toLongArray()
}

/**
 * Prints the sums of query results
 */
fun printSums(a: LongArray) = a.forEach { println(it) }
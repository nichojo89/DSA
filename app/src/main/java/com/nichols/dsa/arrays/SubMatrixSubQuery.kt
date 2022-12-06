package com.nichols.dsa.arrays

fun main(){
//    val A = arrayOf(
//        intArrayOf(-5, -4, -3),
//        intArrayOf(-1,  2,  3),
//        intArrayOf(2,  2,  4)
//    )
//    val A = arrayOf(
//        intArrayOf(-83, -73, -70, -61),
//        intArrayOf(-56, -48, -13, 4),
//        intArrayOf(38, 48, 71, 71)
//    )
    val ans = minSwap(intArrayOf(2, 0, 1, 3))
}

fun minSwap(A: IntArray): Int{
    var swaps = 0
    for(i in A.indices){
        while(A[i] != i){
            //what element is here instead
            val a = A[i]
            //what element is in its spot
            val b = A[a]
            //swap
            A[i] = b
            A[a] = a
            swaps++
        }
    }
    return swaps
}
fun solveMaxOnes(A: Array<IntArray>): Int {
    var ans = 0
    var idx = 0
    for(i in A.indices){
        val ones = A[i].filter { it == 1 }.sum()
//        ans = Math.max(ans,ones)
        if(ones > ans) {
            ans = ones
            idx = i
        }
        if(ans == A.size)
            return i
    }
    return idx
}

fun solveGetMinSwap(A: IntArray, B: Int): Int {
    //get the size of sliding window
    var c = 0
    for (i in A)
        if (i <= B)
            c++

    //count # of elements > 0 in 1st sliding window
    var g = 0
    for (i in 0 until c)
        if (A[i] > B)
            g++

    var ans = g
    var start = 0
    var end = c

    while (end < A.size) {
        if (A[start] > B)
            g--

        if (A[end] > B)
            g++

        //get highest number of elements > B
        ans = Math.min(ans, g)

        //slide the window
        start++
        end++
    }
    return ans
}

fun solveMaxSubSumTwo(A: Array<IntArray>): Long {
    val r = A.size
    val c = A[0].size
    val psum = Array(r){LongArray(c)}

    //create psum for each column
    for(i in A.indices){
        for(j in A[i].indices)
            psum[i][j] =
                if(j == 0)
            A[i][j].toLong()
        else
            A[i][j] + psum[i][j-1]
    }
    var maxSum = Long.MAX_VALUE

    for(i in 0 until c){
        for(j in i until c){
            val v = arrayListOf<Long>()
            for(k in 0 until r){

                val el = if(i == 0)
                    psum[k][j].toLong()
                else
                    psum[k][j] - psum[k][i-1]

                v.add(el)
            }
            maxSum = Math.max(maxSum, kadanesAlgo(v.toLongArray()))
        }
    }
    return maxSum
}


fun kadanesAlgo(A: LongArray) : Long{
    var maxEnding = 0L
    var maxSoFar = Long.MIN_VALUE
    for(i in A.indices){
        maxEnding += A[i]

        if(maxEnding > maxSoFar)
            maxSoFar = maxEnding

        if(maxEnding < 0)
            maxEnding = 0
    }
    return maxSoFar
}

fun solveSubMatrixSum(A: Array<IntArray>): Int{
    val psum = Array(A.size){LongArray(A[0].size)}
    //convert all rows to prefix sum
    for(i in A.indices){
        for(j in A[i].indices){
            if(j != 0)
                psum[i][j] = psum[i][j-1] + A[i][j]
            else
                psum[i][j] = A[i][j].toLong()
        }
    }
    //convert all columns to prefix sum
    val l = A.maxOf{it.size}
    for(i in 0 until l)
        for(j in 0 until A.size)
            if(j != 0)
                psum[j][i] = psum[j-1][i] + psum[j][i]

    return psum.sumOf { it.sum() }.toInt()
}
fun solveSubMatrix(A: Array<IntArray>, B: IntArray, C: IntArray, D: IntArray, E: IntArray): IntArray {
    if(A.isEmpty())
        return intArrayOf(0)

    val psum = Array(A.size){LongArray(A[0].size)}
    //convert all rows to prefix sum
    for(i in A.indices){
        for(j in A[i].indices){
            if(j != 0)
                psum[i][j] = psum[i][j-1] + A[i][j]
            else
                psum[i][j] = A[i][j].toLong()
        }
    }
    //convert all columns to prefix sum
    val l = A.maxOf{it.size}
    for(i in 0 until l)
        for(j in 0 until A.size)
            if(j != 0)
                psum[j][i] = psum[j-1][i] + psum[j][i]

    val ans = IntArray(B.size)
    //for each query in BCDE
    for(i in B.indices){
        val b = B[i]
        val c = C[i]
        val d = D[i]
        val e = E[i]

        val mod=1000000007

        if(b == 1 && c > 1){
            //zero row
            ans[i] = (((psum[d-1][e-1] - psum[d-1][c-2])%mod+mod)%mod).toInt()
        }
        else if(b > 1 && c == 1){
            //zero column
            ans[i] = (((psum[d-1][e-1] - psum[b-2][e-1])%mod+mod)%mod).toInt()
        }
        else if (b+c == 2){
            //0,0
            ans[i] = (((psum[d-1][e-1])%mod+mod)%mod).toInt()
        }
        else {
            ans[i] = (((psum[d-1][e-1] - psum[d-1][c-2] - psum[b-2][e-1] + psum[b-2][c-2])%mod+mod)%mod).toInt()
        }
    }
    return ans
}


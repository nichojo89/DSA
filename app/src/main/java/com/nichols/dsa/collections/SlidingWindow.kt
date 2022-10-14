package com.nichols.dsa.collections

fun main(){
    val a = intArrayOf(1, 12, 10, 3, 14, 10, 5)
    val b = 8
    val c = arrayOf(
        intArrayOf(1 ,2 ,3 ,4 ,5 ,6 ),
        intArrayOf(7 ,8 ,9 ,10,11,12),
        intArrayOf(13,14,15,16,17,18),
        intArrayOf(19,20,21,22,23,24),
        intArrayOf(25,26,27,28,29,30),
        intArrayOf(31,32,33,34,35,36),
    )
    //generateBoundaries(c)
    SlidingWindow().generateMatrix(80)
//    val G = generateMatrix(80)
//    for(q in G){
//        for(u in q){
//            println(u)
//        }
//    }
    solve("11010110000000000")
}

/**
 * returns longest consecutive length of 1's if at most a single 1 is swapped with zero
 */
fun solve(A: String): Int {
    var ans = 0
    var count = 0

    val n = A.length
    //counts the window size
    for(i in 0 until n)
        if(A[i] == '1')
            count++
    if(count == n)
        return n
    if(count == 0)
        return 0
    for(i in 0 until n){
        if(A[i] == '0'){
            var left = 0
            for(j in i-1 downTo 0){
                if(A[j] == '1')
                    left++
                else
                    break
            }
            var right = 0
            for(j in i+1 until n){
                if(A[j] == '1')
                    right++
                else
                    break
            }

            var k = left + right
            if(k < count)
                k++
            if(k > ans)
                ans = k
        }
    }

    return ans
}

fun generateMatrix(A: Int): Array<IntArray> {
    val arr = ArrayList<IntArray>()
    try {
        var i = 0
        var j = 0
        val C = arrayListOf<IntArray>()
        var ii = 1

        //Create sequential 2D matrix
        for(k in 1..A){
            val array = ArrayList<Int>()
            for(l in 1..A){
                array.add(ii)
                ii++
            }
            C.add(array.toIntArray())
        }

        //Spiral iteration
        var n = C.size
        while(n > 1){
            //>>> right
            val t = ArrayList<Int>()
            for(k in 0 until n-1){
                t.add(C[i][j])
                j++
            }
            arr.add(t.toIntArray())
            t.clear()

            //vvv down
            for(k in 0 until n-1){
                t.add(C[i][j])
                i++
            }
            arr.add(t.toIntArray())
            t.clear()

            //<<< left
            for(k in 0 until n-1){
                t.add(C[i][j])
                j--
            }
            arr.add(t.toIntArray())
            t.clear()
            //^^^ up
            for(k in 0 until n-1){
                t.add(C[i][j])
                i--
            }
            arr.add(t.toIntArray())

            i++
            j++
            n -= 2
        }

        if(n == 1)
            arr.add(intArrayOf(C[i][j]))
    } catch (e: Exception){
        val g = 0
    }

    return arr.toTypedArray()
}

fun generateBoundaries(A: Array<IntArray>): Array<IntArray> {
    var n = A.size
    val arr = ArrayList<IntArray>()
    var i = 0
    var j = 0

    val l = A.maxOf { it.size }-1

    //>>> right
    val t = ArrayList<Int>()
    for(k in 0 until l){
        t.add(A[i][j])
        j++
    }
    arr.add(t.toIntArray())
    t.clear()

    //vvv down
    for(k in 0 until n-1){
        t.add(A[i][j])
        i++
    }
    arr.add(t.toIntArray())
    t.clear()

    //<<< left
    for(k in 0 until l){
        t.add(A[i][j])
        j--
    }
    arr.add(t.toIntArray())
    t.clear()
    //^^^ up
    for(k in 0 until n-1){
        t.add(A[i][j])
        i--
    }
    arr.add(t.toIntArray())

    return arr.toTypedArray()
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
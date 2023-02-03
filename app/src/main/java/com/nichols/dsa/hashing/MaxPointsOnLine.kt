package com.nichols.dsa.hashing

fun solveMaxPointsOnLine(x: IntArray, y: IntArray): Int {
    val n = x.size
    if(n<3)
        return n
    var ans = 0
    var curMax = 0
    var overlap = 0

    val hm = hashMapOf<IntArray,Int>()

    for(i in 0 until n){
        curMax = 0
        overlap = 0
        for(j in i+1 until n){
            if(x[i] == x[j] && y[i] == y[j])
                ++overlap
            else {
                var xdiff = x[j] - x[i]
                var ydiff = y[j] - y[i]
                val z = gcdTwo(xdiff,ydiff)
                xdiff /=z
                ydiff /= z
                val arr = intArrayOf(xdiff,ydiff)
                //create frequency hashmap
                if(hm.containsKey(arr))
                    hm[arr] = hm[arr]!! + 1
                else
                    hm[arr] = 1
                curMax = Math.max(curMax,hm[arr]!!)
            }
        }
        hm.clear()
        ans = Math.max(ans,curMax+overlap+1)
    }
    return ans
}

fun gcdTwo(a: Int, b: Int): Int =
    if (a == 0) b else gcd(b % a, a)

fun lengthOfLongestSubstring(A: String): Int {
    if (A.isEmpty())
        return 0
    val n = A.length
    val hs = hashSetOf<Char>()
    var len = 1
    hs.add(A[0])
    var i = 1
    var maxLen = 0
    while (i < n) {
        if (A[i] != A[i - 1] && !hs.contains(A[i])) {
            hs.add(A[i])
            len++
            i++
            if (len > maxLen)
                maxLen = len
        } else {
            if (len == 1)
                i++
            else {
                hs.clear()
                i = i - len + 1
                len = 0
            }
        }
    }
    return Math.max(maxLen, len)
}
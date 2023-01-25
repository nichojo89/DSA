package com.nichols.dsa.binary_search

fun countDistictSubarray(A: IntArray): Int {
    val n = A.size

    val vis = hashMapOf<Int,Int>()
    for (i in 0 until n)
        vis[A[i]] = 1

    val k: Int = vis.size

    vis.clear()

    var ans = 0
    var right = 0
    var window = 0
    for (left in 0 until n) {
        while (right < n && window < k) {
            vis[A[right]] = vis[A[right]]!! + 1
            if (vis[A[right]] === 1) ++window
            ++right
        }

        if (window == k)
            ans += n - right + 1

        vis[A[left]] = vis[A[left]]!! - 1

        if (vis[A[left]] === 0) --window
    }
    return ans
}

fun isPossible(A:Int,B:Int,C:IntArray,x:Long): Boolean {
    val n = C.size
    var t = x
    var i = 0
    var count = 1
    while(i<n){
        if(count>A)
            return false
        if(C[i]>t){
            count++
            t=x
        }
        else {
            t=t-C[i]
            i++
        }
    }
    return true
}


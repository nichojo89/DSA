package com.nichols.dsa.binary_search

fun main(){
    val g = solveasdasd(intArrayOf(1), intArrayOf( 2, 4),4)
}
fun solveasdasd(A: IntArray, B: IntArray, C: Int): IntArray {
    val n = A.size
    val m = B.size
    var l = 0
    var r = m-1
    var diff = Integer.MAX_VALUE
    var leftAns = 0
    var rightAns = 0

    while(l<n && r>=0){
        if(Math.abs(A[l] + B[r] - C) < diff){
            leftAns = l
            rightAns = r
            diff = Math.abs(A[l] + B[r] - C)
        }

        if(A[l] + B[r] > C)
            r--
        else
            l++
    }
    return intArrayOf(A[leftAns],B[rightAns])
}
fun solve(a: IntArray, b: IntArray, c: Int): IntArray? {
    val n = a.size
    val m = b.size
    var l = 0
    var r = m - 1
    var dif = 2e9.toLong()
    val ans = intArrayOf(-1, -1)
    while (l < n && r >= 0) {
        if (Math.abs(a[l] + b[r] - c) < dif) {
            dif = Math.abs(a[l] + b[r] - c).toLong()
            ans[0] = a[l]
            ans[1] = b[r]
        } else if (Math.abs(a[l] + b[r] - c).toLong() == dif && ans[0] == a[l]) {
            ans[1] = b[r]
        }
        if (a[l] + b[r] >= c) r-- else l++
    }
    return ans
}
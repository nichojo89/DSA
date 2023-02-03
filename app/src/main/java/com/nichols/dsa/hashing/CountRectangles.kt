package com.nichols.dsa.hashing

fun solveSSSSS(a: IntArray, b: IntArray): Int {
    val n = a.size
    val mpx: HashMap<Int, HashSet<Int>> = HashMap()
    var h: HashSet<Int>
    // stores all the points
    for (i in 0 until n) {
        h = if (mpx.containsKey(a[i])) mpx[a[i]]!! else HashSet()
        h.add(b[i])
        mpx[a[i]] = h
    }
    var ans = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            // checks if there exists a rectange such that the i-th and
            // j-th points are the ends of a diagonal
            if (a[i] == a[j] || b[i] == b[j]) continue
            if (mpx[a[i]]!!.contains(b[j]) && mpx[a[j]]!!.contains(b[i])) ans++
        }
    }
    return ans shr 1
}

fun main(){
    val g = solveCountRectTwo(intArrayOf(1,2),5)
}
fun solveCountRectTwo(A: IntArray, B:Int): Int {
    val n = A.size
    var count = 0
    var l = 0
    var r = n-1
    while(l < n && r >=1){
        val area = A[l] * A[r]
        if(area<B){
            count += r
            l++
        } else
            r--
    }
    return count
}
//
//fun solve(A: IntArray, B:Int): Int {
//    var ans = 0L
//    val mod = (1000000000 + 7).toLong()
//    var l = 0
//    var r: Int = A.size() - 1
//    while (l < A.size() && r >= 0) {
//        if (A[l].toLong() * A[r] < B) {
//            ans = (ans + r + 1) % mod
//            l++
//        } else r--
//    }
//    return ans.toInt()
//}
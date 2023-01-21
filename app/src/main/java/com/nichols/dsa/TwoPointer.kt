package com.nichols.dsa

fun main(){
    val ans = threeSumClosest(intArrayOf(-10,-10,-10),-5)
}
fun threeSumClosest(A: IntArray, B: Int): Int {
    var current = Integer.MAX_VALUE
    val n = A.size-1
    for(i in 0..n-2){
        var a = i
        var b = i+1
        var c = n
        while(b<c){
            val sum = A[a] + A[b] + A[c]
            if(Math.abs(sum-b) < Math.abs(current-B))
                current = sum-b
            if(sum > B)
                c--
            else if(sum < B)
                b++
            else if(sum == B)
                return B
        }
    }
    return current
}
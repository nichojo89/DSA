package com.nichols.dsa.combinicators

fun titleToNumber(A: String): Int {
    var ans = 0
    var mul = 1
    for(i in A.indices.reversed()){
        ans += mul*(A[i]-'A'+1)
        mul *= 26
    }
    return ans
}

fun solveConsecutiveSums(A: Int): Int {
    var count = 0
    val n = Math.sqrt(2.0*A).toInt()
    for(k in 1..n){
        val t = A-((k*(k-1))/2)
        if(t % k == 0)
            count++
    }
    return count
}


fun main() {
    var str = "BADC"

    val chars = str.toCharArray()
    chars.sort()
    str = String(chars)

    println(str)
}
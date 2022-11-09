package com.nichols.dsa.sorting


fun main(){

    val ab = longestCommonPrefix(arrayOf("ABCD"))
    val f = 0
}
fun longestCommonPrefix(A: Array<String>): String {
    val l = A.minOf { it.length }
    var ans = ""

    for(i in 0..l){
        var isQaulified = true
        val ch = A[0][i]
        for(j in A.indices){
            if(A[j][i] != ch){
                isQaulified = false
                break
            }
        }
        if(isQaulified)
            ans += ch
        else
            return ans

    }
    return ans
}

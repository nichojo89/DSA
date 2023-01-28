package com.nichols.dsa.sorting

import java.util.*

fun main(){
    val two = solveQQQ("ccbcdaacc","ac")
    val three = solveQQQ("aaaa","aa")
}
fun solveQQQ(A: String, B: String): Int {
    val z = intArrayOf()
    val n = A.length
    for(i in 1 until n){
        var j = 1
        var k = 0
        while(j<n && A[j] == A[k]){
            j++
            k++
        }
        z[i] = k
    }
    return z.maxOf { it }
}

fun reverseWords(A: String): String {
    if (A.isEmpty())
        return ""
    val c = A.toCharArray()
    val m = c.size
    // Clean up spaces
    val a = cleanSpaces(c, m)
    val n = a.size
    // Reverse string
    reverse(a, 0, n - 1)
    // Reverse each word
    reverseWords(a, n)
    return String(a)
}

private fun reverseWords(a: CharArray, n: Int) {
    var i = 0
    while (i < n) {
        while (i < n && a[i] == ' ')
            i++

        var j = i
        while (j < n && a[j] != ' ')
            j++

        reverse(a, i, j - 1)

        i = j
    }
}

private fun cleanSpaces(a: CharArray, n: Int): CharArray {
    var i = 0
    var j = 0
    while (i < n && j < n) {
        // skip spaces
        while (j < n && a[j] == ' ')
            j++

        //Copy non-spaces
        while (j < n && a[j] != ' ')
            a[i++] = a[j++]

        //skip spaces
        while (j < n && a[j] == ' ')
            j++
        //append one space
        if (j < n)
            a[i++] = ' '
    }
    return a.copyOf(i)
}

private fun reverse(a: CharArray, B: Int, C: Int) {
    var i = B
    var j = C
    while (i < j) {
        val t = a[i]
        a[i++] = a[j]
        a[j--] = t
    }
}
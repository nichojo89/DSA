package com.nichols.dsa.sorting

import kotlin.math.max

fun main() {
    val aaabaaa = longestPalindromeOptimized("aaaabaaa")
    val g = 0
}

fun longestPalindromeOptimized(A: String): String {
    val n = A.length
    var ans = 0
    val arr = A.toCharArray()
    var palindrome = ""
    //get odd palindromes
    for(i in 0 until n){
        val p1 = i
        val p2 = i

        val c = expand(arr,p1,p2)
        if(c > ans){
            ans = c
            val start = p1 - (ans/2)
            val end = p1 + (ans/2)
            palindrome = A.substring(start,end+1)
            val g = 0
        }
    }
    //get even palindromes
    for(i in 0 until n-1){
        val p1 = i
        val p2 = i+1

        val c = expand(arr,p1,p2)
        if(c > ans){
            ans = c
            val start = p2 - (ans/2)
            val end = p1 + (ans/2)
            palindrome = A.substring(start,end+1)
        }
    }

    return palindrome
}

fun expand(a: CharArray, b: Int, c: Int) : Int{
    val n = a.size
    var p1 = b
    var p2 = c
    while(p1 >= 0 && p2 < n && a[p1] == a[p2]){
        p1--
        p2++
    }
    return p2-p1-1
}

fun longestPalindromeBruteForce(A: String): String {
    var ans = 0
    var palindrome = ""
    for(i in A.indices){
        for(j in i until A.length ){
            if(isPalindrome(A,i,j)){
                val a = j-i+1

                if(a > ans){
                    ans = a
                    palindrome = A.substring(i,j+1)
                }
            }
        }
    }

    return palindrome
}

fun isPalindrome(A: String, s: Int, e: Int) : Boolean {
    var S = s
    var E = e
    while(S < E){
        if(A[s] != A[e])
            return false

        S++
        E--
    }
    return true
}
package com.nichols.dsa.strings

fun main() {
    val r = solveReversedString("the sky is blue")
}
fun solveReversedString(A: String): String {
    val n = A.length
    var ans = ""

    var i = n-1
    while(i >= 0){
//        i--
        if(A[i] != ' '){
            var current = ""

            while(i >= 0 && A[i] != ' '){
                current += A[i]
                i--
            }
            current = current.reversed()
            if(ans.isNotEmpty())
                ans += ' '

            ans += current
        }
        i--

    }
    return ans
}
fun solve(A: String): String = A.split(" ").reduce{acc, x -> x + " " + acc}
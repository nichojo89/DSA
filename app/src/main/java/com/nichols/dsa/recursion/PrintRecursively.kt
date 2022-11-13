package com.nichols.dsa.recursion

fun main(){
//    solvePrint(9)
    printBottomUp(10,10-1)
}



fun solve(A: String): Int = solvePalindrome(A,0,A.length)

fun solvePalindrome(A: String, s: Int, e: Int) : Int {
    if(s>e)
        return 1

    return if(A[s] == A[e] && solvePalindrome(A,s + 1,e - 1) == 1) 1 else 0
}

fun solvePrint(A: Int){
    if(A != 0){
        print(A)
        solvePrint(A-1)
    }
}

fun printBottomUp(A: Int, B: Int){
    if(B==0)
        return

    val msg = "${A-B} "
    print(msg)
    printBottomUp(A,B-1)
}

fun fib(A: Int): Int{
    if(A <= 1)
        return A

    return fib(A-1) + fib(A-2)
}
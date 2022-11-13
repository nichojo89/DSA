package com.nichols.dsa.recursion

import java.util.Scanner



fun main(args: Array<String>) {
    val scn = Scanner(System.`in`)
    while (scn.hasNextLine()){
        val s = scn.nextLine()
        printRecurssive(s,s.length-1)
    }

}

fun printRecurssive(A: String, i: Int){
    if(i<0)
        return

    print(A[i])
    printRecurssive(A, i-1)
}
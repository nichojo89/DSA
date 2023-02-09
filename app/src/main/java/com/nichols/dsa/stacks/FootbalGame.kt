package com.nichols.dsa.stacks

import java.util.*

fun solveFootballGame(A: Int, B: Int, C: IntArray): Int {
    val stk = Stack<Int>()
    stk.push(B)
    for(i in C)
        if(i==0)
            stk.pop()
        else
            stk.push(i)
    return stk.last()
}
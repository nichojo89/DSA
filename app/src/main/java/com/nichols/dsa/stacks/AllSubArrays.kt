package com.nichols.dsa.stacks

import java.util.*

fun solveAllSubArryas(A: IntArray): Int {
    var ans = 0
    val stk = Stack<Int>()
    for(i in A.indices){
        while(stk.isNotEmpty()){
            ans = Math.max(ans, A[stk.peek()] xor A[i])
            if(A[stk.peek()] > A[i])
                break

            stk.pop()
        }
        stk.push(i)
    }

    return ans
}
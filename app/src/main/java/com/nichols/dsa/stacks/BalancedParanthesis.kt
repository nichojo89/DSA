package com.nichols.dsa.stacks

import java.util.*

fun main(){
    val a = solveBalancedParenthesis("))))))))")
}
fun solveBalancedParenthesis(A: String): Int {
    val stk = Stack<Char>()
    for(c in A){
        //open parenthesis push
        //close paranthesis pop & if stack is empty & top is not matching
        //open paranthesis then return 0
        when(c){
            '(','[','{' -> stk.push(c)
            ')' -> if(stk.isEmpty() || stk.last() != '(')
                        return 0
                    else
                        stk.pop()
            ']' -> if(stk.isEmpty() || stk.last() != '[')
                    return 0
                else
                    stk.pop()
            '}' -> if(stk.isEmpty() || stk.last() != '{')
                    return 0
                else
                    stk.pop()

        }
    }
    return if(stk.isEmpty()) 1 else 0
}
package com.nichols.dsa.stacks

import java.util.*

fun evalRPN(A: Array<String>): Int {
    val operators: Set<String> = HashSet(listOf("+", "-", "*", "/"))
    val stk = Stack<Int>()
    for (c in A) {
        if (!operators.contains(c)) stk.push(c.toInt()) else {
            val b = stk.pop()
            val a = stk.pop()
            if (c == "+") stk.push(a + b) else if (c == "-") stk.push(a - b) else if (c == "*") stk.push(
                a * b
            ) else stk.push(a / b)
        }
    }
    return stk.pop()
}
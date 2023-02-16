package com.nichols.dsa.stacks

import java.util.*

fun main(){
    prevSmaller(intArrayOf(4,5,2,10,8))
}
fun prevSmaller(arr: IntArray) : IntArray {
    val stk = Stack<Int>()
    val ans = IntArray(arr.size)
    for(i in arr.indices){
        //pop all >= elems
        while(stk.size > 0 && stk.last() >= arr[i])
            stk.pop()

        //update ans
        ans[i] =  if(stk.size == 0) -1 else stk.last()

        //push current elem in stack
        stk.push(arr[i])
    }
    return ans
}
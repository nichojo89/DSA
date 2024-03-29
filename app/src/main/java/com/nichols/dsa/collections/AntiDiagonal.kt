package com.nichols.dsa.collections

import java.util.*

fun main(){
    val G = intArrayOf(36, 63, 63, 26, 87, 28, 77, 93, 7)
    val B = solveING(G)
    val c = 0
}
fun solveING(A: IntArray): Array<IntArray> {
    val subs = arrayListOf<IntArray>()
    for(i in A.indices){
        for(j in i until A.size){
            val x = ArrayList<Int>()
            for(k in i..j){
                x.add(A[k])
            }
            subs.add(x.toIntArray())
        }
    }

    return subs.toTypedArray()
}

/**
 * Traverse in an anti-diagonal pattern and add 0 to make the 2D array horizontally even
 */
fun antiDiagonals(A: Array<IntArray>): Array<IntArray>{

    //largest array size
    val m = A.maxOf { it.size }
    val result = arrayListOf<IntArray>()

    for(j in 0 until m){
        var r = 0
        var c = j
        val arr = ArrayList<Int>(m)

        //traverse anti diagonally
        while(r < m){
            if(r < A.size && c >= 0){
                print(A[r][c])
                arr.add(A[r][c])
            } else {
                arr.add(0)
            }

            r++
            c--
        }
        result.add(arr.toIntArray())
    }

    for(i in 0 until A.size-1){
        var r = i+1
        var c = m-1
        val arr = ArrayList<Int>(m)

        for(i in 0 until m){
            if(r < A.size && c >= 0){
                print(A[r][c])
                arr.add(A[r][c])
            } else {
                arr.add(0)
            }

            r++
            c--
        }
        result.add(arr.toIntArray())
    }


    return result.toTypedArray()
}
fun diagonal(A: Array<IntArray>) {
    val n = A.size
    val N = 2 * n - 1
    val result: Array<IntArray> = Array(5){_ -> IntArray(3)}

    // Push each element in the result vector
    for (i in 0 until n)
        for (j in 0 until A[i].size) {
            val index = i + j
            val row = result[index]
            row[row.size] = A[i][j]
//            1
//            2 4
//            3 5 7
//            6 8
//            9
        }


    // Print the diagonals
    for (i in 0 until result.size) {
        println()
        for (j in 0 until result[i].size)
            print(result[i][j].toString() + " ")
    }
}

fun diagonals(A: Array<IntArray>): Array<IntArray>{
    val n = A.size
    val N = 2 * n - 1
    val result: ArrayList<ArrayList<Int>> = ArrayList()
    for (i in 0 until N)
        result.add(ArrayList())

    var maxIndex = 0
    // Push each element in the result vector
    for (i in 0 until n){
        for (j in 0 until n){
            val x = A[i][j]
            val index = i + j

            result[index].add(x)

            if(j > maxIndex)
                maxIndex = j
        }
    }

    //add zeros
    for(arr in result){
        //needs zeros
        if(arr.size-1 != maxIndex){

            for(i in 0..maxIndex){
                if(i > arr.size-1){
                    arr.add(0)
                }
            }
        }
    }

    val test =0
    return A
}




fun LBSlength(A: String): Int {
    var maxLength = 0
    var stk = Stack<Int>()

    stk.push(-1)

    for(i in A.indices){
        var c =  A[i]

        if(c  == '(' || c == '[' || c == '{')
            stk.push(i)
        else if (c == ')' || c == '}' || c == ']'){
            if(stk.size > 1){
                var top = A[stk.peek()];

                if(c == ')' && top == '('  || c == '}'  &&  top == '{' || c == ']' && top == '['){
                    stk.pop()
                    maxLength = Math.max(maxLength,i-stk.peek())
                }
            } else {
                stk.clear()
                stk.push(i)
            }
        }
    }
    return maxLength
}

fun findLongestBalancedSubstringLength(str: String): Int {
    var maxLength = 0
    val stack: Stack<Int> = Stack()
    stack.push(-1) // Initialize stack with a dummy index
    for (i in str.indices) {
        val c = str[i]
        if (c == '(' || c == '[' || c == '{') {
            stack.push(i)
        } else if (c == ')' || c == ']' || c == '}') {
            if (stack.size > 1) {
                val top = str[stack.peek()]
                if (c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{') {
                    stack.pop()
                    maxLength = Math.max(maxLength, i - stack.peek())
                } else {
                    stack.clear()
                    stack.push(i)
                }
            } else {
                stack.clear()
                stack.push(i)
            }
        }
    }
    return maxLength
}
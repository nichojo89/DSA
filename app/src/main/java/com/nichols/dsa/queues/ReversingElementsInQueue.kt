package com.nichols.dsa.queues

import java.util.*

fun solveContainingNumbers(A: Int): IntArray {
    val q: Queue<Int> = LinkedList()
    val ans: ArrayList<Int> = ArrayList()
    q.add(1)
    q.add(2)
    q.add(3)
    var cnt = 3
    while (ans.size < A) {
        val x = q.peek()
        ans.add(x)
        q.remove()
        if (cnt >= A) continue
        // append 1, 2 and 3 to the current number
        q.add(10 * x + 1)
        q.add(10 * x + 2)
        q.add(10 * x + 3)
        cnt += 3
    }
    return ans.toIntArray()
}

fun main(){
    val a = solveReversingElementsInQueue(intArrayOf(1, 2, 3, 4, 5), 3)
}
fun solveReversingElementsInQueue(A: IntArray, B: Int): IntArray {
    val stk = Stack<Int>()
    for(i in 0 until B)
        stk.push(A[i])

    for(i in 0 until B)
        A[i] = stk.pop()

    return A
}

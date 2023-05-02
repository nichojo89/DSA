package com.nichols.dsa.heaps

import java.util.*

fun sortQueue(queue: IntArray, B: Int): IntArray? {
    val N = queue.size
    val pq: PriorityQueue<Int> = PriorityQueue()
    val sortedQueue = IntArray(N)
    for (i in 0..B) {
        pq.offer(queue[i])
    }
    var index = 0
    for (i in B + 1 until N) {
        sortedQueue[index++] = pq.poll()
        pq.offer(queue[i])
    }
    while (!pq.isEmpty()) {
        sortedQueue[index++] = pq.poll()
    }
    return sortedQueue
}
fun main () {

    val a = intArrayOf(1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17)
    buildMaxHeap(a)
}
fun buildMaxHeap(A: IntArray){
    val n = A.size
    //index of the last non-leaf node is
    var startingIndex = (n/2) - 1

    for(i in startingIndex downTo  0)
        heapify(A,i)
    //17 15 13 9 6 5 10 4 8 3 1
    var f = 0
}

fun heapify(A: IntArray, i: Int){
    val n = A.size
    var largestValue = i
    var left = 2*i+1
    var right = 2*i+2

    if(left <  n && A[left] > A[largestValue])
        largestValue = left

    if(right < n && A[right] > A[largestValue])
        largestValue = right
    //if largest is not root
    if(largestValue != i){
        //swap the values of current with largest
        var swap = A[i]
        A[i] =  A[largestValue]
        A[largestValue] = swap

        //recursively heapify the affected sub tree
        heapify(A,largestValue)
    }

}


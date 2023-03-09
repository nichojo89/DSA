package com.nichols.dsa.heaps

import com.nichols.dsa.LinkedListAssignments.ListNode
import java.util.*

class MergeKList {
    fun mergeKLists(a: ArrayList<ListNode?>): ListNode? {
        val n = a.size
        val minimumHeap = PriorityQueue<Int>()
        for (i in a.indices) {
            var head = a[i]
            while (head != null) {
                minimumHeap.add(head.`val`)
                head = head.next
            }
        }
        val dummy = ListNode(-1)
        var head = dummy
        while (!minimumHeap.isEmpty()) {
            head.next = ListNode(minimumHeap.remove())
            head = head.next
        }
        return dummy.next
    }
}
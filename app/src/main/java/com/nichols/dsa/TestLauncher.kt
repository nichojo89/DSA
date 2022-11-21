package com.nichols.dsa

import com.nichols.dsa.LinkedListAssignments.InsertK
import com.nichols.dsa.LinkedListAssignments.ListNode
fun main(){
    val t = InsertK()
    val a = ListNode(1)
    val b = ListNode(2)
    a.next = b

    val ans1 = t.solveInsertAtK(a,3,0)
    //val ans2 = t.solveInsertAtK(a,3,1)
    val c = ListNode(7)

    //6 -> 4 -> 9 -> 5 -> 6 -> 1 -> 9 -> 1
    val d = ListNode(6)
    val e = ListNode(4)
    val f = ListNode(9)
    val g = ListNode(5)
    val h = ListNode(6)
    val i = ListNode(1)
    val j = ListNode(9)
    d.next = e;
    e.next = f;
    f.next = g;
    g.next = h;
    h.next = i;
    i.next = j;
    val ans3 = t.solveInsertAtK(d,1,8)
}
package com.nichols.dsa.LinkedListAssignments

import com.nichols.dsa.hashing.solveSubSumTwo

fun main(){

    //6 3 3 6 7 8 7 3 7
    val nodeA = ListNode(6)
    val nodeB = ListNode(3)
    val nodeC = ListNode(3)
    val nodeD = ListNode(6)
    val nodeE = ListNode(7)
    val nodeF = ListNode(8)
    val nodeG = ListNode(7)
    val nodeH = ListNode(3)
    val nodeI = ListNode(7)
    nodeA.next = nodeB
    nodeB.next = nodeC
    nodeC.next = nodeD
    nodeD.next = nodeE
    nodeE.next = nodeF
    nodeF.next = nodeG
    nodeG.next = nodeH
    nodeH.next = nodeI

    val pll = PrintLinkedList()
    val g = pll.solve(nodeA)
}
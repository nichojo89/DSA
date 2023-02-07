package com.nichols.dsa.LinkedLists;

import com.nichols.dsa.LinkedListAssignments.ListNode;

public class LinkedListPartition {
    public ListNode partition(ListNode A, int B)
    {
        ListNode smallerHead = null, smallerLast = null;
        ListNode greaterLast = null, greaterHead = null;
        ListNode equalHead = null, equalLast = null;

        while (A != null) {
            if (A.val == B) {
                if (equalHead == null)
                    equalHead = equalLast = A;
                else {
                    equalLast.next = A;
                    equalLast = equalLast.next;
                }
            } else if (A.val < B) {
                if (smallerHead == null)
                    smallerLast = smallerHead = A;
                else {
                    smallerLast.next = A;
                    smallerLast = A;
                }
            } else {
                if (greaterHead == null)
                    greaterLast = greaterHead = A;
                else {
                    greaterLast.next = A;
                    greaterLast = A;
                }
            }
            A = A.next;
        }

        if (greaterLast != null)
            greaterLast.next = null;

        if (smallerHead == null) {
            if (equalHead == null)
                return greaterHead;
            equalLast.next = greaterHead;
            return equalHead;
        }

        if (equalHead == null) {
            smallerLast.next = greaterHead;
            return smallerHead;
        }

        smallerLast.next = equalHead;
        equalLast.next = greaterHead;

        return smallerHead;
    }
}

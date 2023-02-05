package com.nichols.dsa.LinkedLists;

import com.nichols.dsa.LinkedListAssignments.ListNode;

public class MergeSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        //Create two pointers
        ListNode t1 = A;
        ListNode t2 = B;


        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;

        //Set head to smaller of the pointers
        ListNode head = null;
        ListNode tail = null;
        if(t1.val <= t2.val){
            head = t1;
            tail = t1;
            t1 = t1.next;
        } else {
            head = t2;
            tail = t2;
            t2 = t2.next;
        }
        // ListNode p = head;
        while(t1 != null && t2 != null){
            //point to smallers and move next
            if(t1.val < t2.val){
                tail.next = t1;
                t1 = t1.next;
                tail = tail.next;
            } else {
                tail.next = t2;
                t2 = t2.next;
                tail = tail.next;
            }
        }
        //Assign remaining nodes
        if(t1 == null){
            tail.next = t2;
        }
        if(t2 == null){
            tail.next = t1;
        }
        return head;
    }
}

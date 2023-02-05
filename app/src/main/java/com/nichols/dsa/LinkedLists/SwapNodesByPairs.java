package com.nichols.dsa.LinkedLists;

import com.nichols.dsa.LinkedListAssignments.ListNode;

public class SwapNodesByPairs {
    public ListNode swap(ListNode A, ListNode B){
        A.next = B.next;
        B.next = A;

        return B;
    }
    public ListNode swapPairs(ListNode A) {
        ListNode start = new ListNode(0);
        start.next = A;
        ListNode curr = start;
        while(curr.next !=null && curr.next.next != null){
            curr.next = swap(curr.next, curr.next.next);
            curr = curr.next.next;
        }
        return start.next;
    }
}

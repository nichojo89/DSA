package com.nichols.dsa.LinkedLists;

public class BreakLoopLinkedList {
    public ListNode solveBreakLoop(ListNode A) {
        if(A==null || A.next == null)
            return A;

        ListNode slow = A;
        ListNode fast = A;
        slow = slow.next;
        fast = fast.next.next;

        while(slow != null && fast != null && fast.next != null){
            if(slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast){
            int len = 1;
            while(fast.next != slow){
                fast = fast.next;
                len++;
            }
            removeLoop(A,len);
        }
        return A;
    }
    void removeLoop(ListNode head, int pos){
        ListNode t1 = head;
        ListNode t2 = head;
        while(pos > 0){
            t2 = t2.next;
            pos--;
        }
        while(t1.next != t2.next){
            t1 = t1.next;
            t2 = t2.next;
        }
        t2.next = null;
    }
}

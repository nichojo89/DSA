package com.nichols.dsa.LinkedLists;

import com.nichols.dsa.LinkedListAssignments.ListNode;


public class IsPalindrome {

    public int lPalin(ListNode A)
    {
        ListNode slow = A;
        ListNode fast = A.next;
        int result = 1;
        if(A.next != null)
        {
            while(fast != null && fast.next != null)
            {
                fast = fast.next.next;
                slow = slow.next;
            }
            if(fast != null)
                slow = slow.next;

            ListNode secondHalf = slow;
            ListNode reversedHalf = reverse(secondHalf);
            result= compareList(A, reversedHalf);
        }
        return result;
    }

    private int compareList(ListNode t1 ,ListNode t2)
    {
        while(t1 != null && t2 != null)
        {
            if(t1.val != t2.val)
                return 0;
            t1 = t1.next;
            t2 = t2.next;
        }
        return 1;
    }

    public ListNode reverse(ListNode A){
        ListNode prev = null;
        ListNode current = A;
        ListNode next = null;
        while(current != null){
            next= current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        A = prev;
        return A;
    }
}

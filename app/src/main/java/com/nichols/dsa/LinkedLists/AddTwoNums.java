package com.nichols.dsa.LinkedLists;

import com.nichols.dsa.LinkedListAssignments.ListNode;

public class AddTwoNums {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        return calculateTerms(A, B, 0);
    }

    ListNode calculateTerms(ListNode t1, ListNode t2, int carry)
    {
        if(t1 == null && t2 == null && carry == 0)
            return null;
        if(t1 == null && t2 == null && carry != 0)
            return new ListNode(1);

        int temp = (t1 == null ? 0: t1.val) + (t2 == null ? 0: t2.val) + carry;
        ListNode result = new ListNode(temp % 10);
        result.next = calculateTerms(t1 == null ? null: t1.next, t2==null? null: t2.next, temp/10);
        return result;
    }
}

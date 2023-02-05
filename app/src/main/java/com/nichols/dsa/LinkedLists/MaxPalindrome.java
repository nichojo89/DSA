package com.nichols.dsa.LinkedLists;

import com.nichols.dsa.LinkedListAssignments.ListNode;

public class MaxPalindrome {
    public int maxPalindrome(ListNode A)
    {
        int result = 0;
        ListNode prev = null, curr = A;
        while (curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;

            result = Math.max(result, 2 * countPalindromeMax(prev, next)+1);
            result = Math.max(result, 2* countPalindromeMax(curr, next));
            prev = curr;
            curr = next;
        }
        return result;
    }
    private int countPalindromeMax(ListNode A, ListNode B)
    {
        int count = 0;
        for (; A != null && B != null; A = A.next, B = B.next)
            if (A.val == B.val)
                ++count;
            else
                break;

        return count;
    }
}

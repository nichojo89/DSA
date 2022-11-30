package com.nichols.dsa.LinkedListAssignments;

public class AscendingCheck {
    public int solveAsc(ListNode A) {
        int cur = Integer.MIN_VALUE;
        while(A != null){
            if(cur >= A.val)
                return 0;

            cur = A.val;
            A = A.next;
        }
        return 1;
    }
}

package com.nichols.dsa.LinkedLists;

import com.nichols.dsa.LinkedListAssignments.ListNode;

public class LinkedListIntersection {
//    public ListNode getIntersectionNode(ListNode A, ListNode B) {
//        while(B != null){
//            ListNode temp = A;
//            while(temp != null){
//                if(temp == B)
//                    return B;
//                temp = temp.next;
//            }
//            B = B.next;
//        }
//        return null;
//    }
public ListNode getIntersectionNode(ListNode A, ListNode B)
{
    int c1 = getCount(A);
    int c2 = getCount(B);
    int d;

    if (c1 > c2) {
        d = c1 - c2;
        return GetIntersectionTraverseFromCenter(d, A, B);
    }
    else {
        d = c2 - c1;
        return GetIntersectionTraverseFromCenter(d, B, A);
    }
}

    private ListNode GetIntersectionTraverseFromCenter(int d, ListNode node1, ListNode node2)
    {
        int i;
        ListNode current1 = node1;
        ListNode current2 = node2;
        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return null;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.val == current2.val) {
                return current1;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return null;
    }

    private int getCount(ListNode node)
    {
        ListNode current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}

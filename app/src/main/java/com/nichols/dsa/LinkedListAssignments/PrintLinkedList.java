package com.nichols.dsa.LinkedListAssignments;

public class PrintLinkedList {
    public ListNode solveInsertAt(ListNode A, int B, int C) {
        ListNode D = A;

        if(C == 1){
            ListNode nn = new ListNode(B);
            nn.next = A;
        } else {
            while(C-- != 0){
                if(C == 1){
                    ListNode nn = new ListNode(B);
                    nn.next = A.next;
                    A.next = nn;
                    break;
                }
                A = A.next;
            }
        }
        return A;
    }
    public void solve(ListNode A) {
        while(A.next != null){
            System.out.print(A.val + " ");
            A = A.next;
        }
    }
}

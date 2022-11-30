package com.nichols.dsa.LinkedListAssignments;

public class PrintLinkedList {
    public ListNode solveDeleteAt(ListNode A, Integer B){
        ListNode prev = A;
        ListNode curr = A;
        Integer i = 0;
        while(curr != null){
            if(i.equals(B)){
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        return A;
    }
    public void solvePrintList(ListNode A){
        if(A == null)
            return;

        System.out.println(A.val + "->");
        solvePrintList(A.next);
    }
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

package com.nichols.dsa.LinkedListAssignments;

public class InsertK {
    public ListNode solve(ListNode A, int B, int C){
        ListNode nn = new ListNode(B);
        //edge case
        if(C == 0)
            return insertAtStart(A, B);
        else {
            ListNode temp = A;
            for(int i= 1; i <C; i++){
                if(temp.next == null) {
                    temp.next = nn;
                    return A;
                }
                //iterate until you get to the kth index
                temp = temp.next;
            }
            nn.next = temp.next;
            temp.next = nn;

            return A;
        }
    }

    public ListNode insertAtStart(ListNode A, int value){
        ListNode nn = new ListNode(value);
        nn.next = A;
        A = nn;
        return A;
    }
}

package com.nichols.dsa.LinkedLists;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class ReversedList{
    public ListNode reverseList(ListNode A) {
        ListNode head = A;

        if(head == null)
            return null;

        if(head.next == null)
            return head;

        ListNode curr = head;
        ListNode nextNode = curr;
        ListNode prevNode = null;

        while(curr != null){
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }
        head = prevNode;
        return head;
    }
}

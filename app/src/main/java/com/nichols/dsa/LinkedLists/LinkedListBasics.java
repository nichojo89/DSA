package com.nichols.dsa.LinkedLists;

import com.nichols.dsa.LinkedListAssignments.ListNode;

public class LinkedListBasics {
    public static Node head;

    public static void insert_node(int position, int value) {
        Node temp = head;
        if(position < 1)
            return;
        if(position == 1){
            Node nn = new Node(value);
            nn.next = head;
            temp = nn;
        } else {
            while (position-- != 0) {
                if (position == 1) {
                    Node newNode = new Node(value);
                    newNode.next = head.next;
                    head.next = newNode;
                    break;
                }
                head = head.next;
            }
        }
    }

    public static void delete_node(int position) {
        if(head == null)
            return;

        Node temp = head;

        if(position == 0){
            head = temp.next;
            return;
        }

        for(int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if(temp.next== null || temp.next.next == null)
        return;

        Node next = temp.next.next;
        temp.next = next;
    }

    public static void print_ll() {
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
    }
    static class Node{
        int value;
        Node next;
        Node(int d) {value = d;}
    }
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode curr = A;
        ListNode first = null;
        ListNode from = null;
        ListNode to = null;
        ListNode last = null;
        int count = 0;
        while(curr != null){
            count++;
            if(count < B)
                first = curr;
            if(count == B){
                from = curr;
            }
            if(count == C){
                to = curr;
                last = to.next;
                break;
            }
            curr = curr.next;
        }
        to.next = null;
        reverseList(from);
        if(first != null)
            first.next = to;
        else
            A = to;
        from.next = last;
        return A;
    }
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


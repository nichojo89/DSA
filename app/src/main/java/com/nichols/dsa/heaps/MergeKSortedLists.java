package com.nichols.dsa.heaps;

import com.nichols.dsa.LinkedListAssignments.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int n = a.size();
        PriorityQueue<Integer> minimumHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            ListNode head = a.get(i);
            while(head != null){
                minimumHeap.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!minimumHeap.isEmpty())
        {
            head.next = new ListNode(minimumHeap.remove());
            head = head.next;
        }
        return dummy.next;
    }

}

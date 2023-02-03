package com.nichols.dsa.LinkedList;

import java.util.HashMap;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }


public class RandomNode {
    public RandomListNode copyRandomList(RandomListNode head)
    {
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        RandomListNode temp, nhead;

        temp = head;
        nhead = new RandomListNode(temp.label);
        hm.put(temp, nhead);

        while (temp.next != null) {
            nhead.next = new RandomListNode(temp.next.label);
            temp = temp.next;
            nhead = nhead.next;
            hm.put(temp, nhead);
        }
        temp = head;

        while (temp != null) {
            hm.get(temp).random = hm.get(temp.random);
            temp = temp.next;
        }

        return hm.get(head);
    }
}

package com.nichols.dsa.LinkedListAssignments;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer,Node> nodeMap;
    int cacheCapacity;
    public LRUCache(int capacity) {
        nodeMap = new HashMap(capacity);
        this.cacheCapacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        int result = 1;
        Node node = nodeMap.get(key);
        if(node != null){
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void set(int key, int value) {
        Node node = nodeMap.get(key);
        if(node != null){
            remove(node);
            node.val = value;
            add(node);
        } else {
            if(nodeMap.size() == cacheCapacity){
                //remove from hm
                nodeMap.remove(tail.prev.key);
                //remove tail from linked list
                remove(tail.prev);
                Node nn = new Node();
                nn.key = key;
                nn.val = value;

                nodeMap.put(key,nn);
                add(nn);
            }
        }
    }

    public void add(Node node){
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
    public void remove(Node node){
        Node nn = node.next;
        Node prev = node.prev;

        nn.prev = prev;
        prev.next = nn;
    }
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}

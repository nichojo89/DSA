package com.nichols.dsa.LinkedListAssignments;

import com.nichols.dsa.LinkedList;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//Ref -> https://www.enjoyalgorithms.com/blog/implement-least-recently-used-cache
public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    private Hashtable<Integer, Node> cache = new Hashtable();
    private int count;
    private int capacity;
    private Node head, tail;

    //Remove node from linked list
    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node){
        this.removeNode(node);
        this.addNode(node);
    }


    private Node popTail(){
        Node res = tail.prev;
        this.removeNode(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null)
            return -1;
        this.moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node = cache.get(key);

        if(node == null){
            Node nn = new Node();
            nn.key = key;
            nn.value = value;

            this.cache.put(key,nn);
            this.addNode(nn);

            ++count;

            if(count>capacity){
                //pop the tail
                Node tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}

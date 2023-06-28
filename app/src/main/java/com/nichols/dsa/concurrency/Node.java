package com.nichols.dsa.concurrency;

import java.util.Iterator;

class Node implements Iterable<Node> {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public int getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    private class NodeIteration implements Iterator<Node> {
        private Node currentNode;

        public NodeIteration(Node startNode) {
            this.currentNode = startNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Node next() {
            Node node = currentNode;
            currentNode = currentNode.getNext();
            return node;
        }
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIteration(this);
    }

}

package com.nichols.dsa

class LinkedListIterator<T>(
    private val list: LinkedList<T>
): Iterator<T> {
    private var index = 0
    private var lastNode: Node<T>? = null
    override fun next(): T {
        TODO("Not yet implemented")
    }

    /**
     * is index less than linked list iterator size?
     */
    override fun hasNext(): Boolean {
        return index > list.size
    }
}
package com.nichols.dsa

fun main() {
    val list = LinkedListTierTwo<Int>()
    list.push(3).push(2).push(1)

    println("Before $list")
    for(node in list){
        println("Double: ${node * 2}")
    }
    println("After $list")
}

/**
 * Tier 1, Iterable base
 */
class LinkedListTierTwo<T> : Collection<T>{
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    /**
     * Override size of Collection type
     */
    override var size = 0
        private set

    override fun toString(): String {
        if(isEmpty()){
            return "Empty List"
        } else {
            return head.toString()
        }
    }

    /**
     * Override when the LinkedList is iterated through,
     * Like in a for loop for example
     */
    override fun iterator(): Iterator<T> {
        return this.iterator()
    }

    /**
     * override isEmpty from Collection
     */
    override fun isEmpty(): Boolean = size == 0

    /**
     * Adds a value at the front of the list
     * Uses Fluent Interface pattern to chain calls to push
     */
    fun push(value: T): LinkedListTierTwo<T>{
        //The first node will have a null next
        //set the previous head as next
        head = Node(value = value, next = head)

        if(tail == null){
            //If theres no tail, then this is first node
            //So set head to tail
            tail = head
        }
        size++

        return this
    }

    /**
     * Adds a value at the end of the list
     */
    fun append(value: T) : LinkedListTierTwo<T>{
        //Use push if list is empty
        if(isEmpty()){
            push(value)
            return this
        }
        //appends node to end
        tail?.next = Node(value)
        //assigns tail to new end
        tail = tail?.next
        size++

        return this
    }

    /**
     * Adds a value after a particular node of the list
     */
    fun insert(value :T,afterNode: Node<T>): Node<T>{
        if(afterNode == tail){
            append(value)
            return tail!!
        }
        val node = Node(value,afterNode.next)
        afterNode.next = node
        size++
        return node
    }

    /**
     * Traverse up the list til it gets the node til index
     */
    fun nodeAt(index: Int) : Node<T>?{
        var currentNode = head
        var currentIndex = 0

        while(currentNode?.next != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    /**
     * Removes value from front of the list
     */
    fun pop(): T? {
        if(!isEmpty()) size--
        val result = head?.value
        head = head?.next

        if(isEmpty()){
            tail = null
        }
        return result
    }

    /**
     * Removes the value at the end of list
     */
    fun removeLast(): T?{
        val head = head ?: return null

        if(head.next == null) return pop()

        size--

        var prev = head
        var current = head
        var next = current.next

        while(next != null){
            prev = current
            current = next
            next = current.next
        }
        //disconnect last node
        prev.next = null
        tail = prev

        return current.value
    }

    /**
     * Removes a value anywhere in list
     */
    fun removeAfter(afterNode: Node<T>): T?{
        //Get aftername value
        val result = afterNode.next?.value
        //if afterNode's next one is the tail
        if(afterNode.next == tail){
            //Than make afterNode the tail
            tail = afterNode
        }
        //decrease size if there's a node to remove after
        if(afterNode.next != null){
            size--
        }

        //Remove node by setting next to next.next
        afterNode.next = afterNode.next?.next
        return result
    }

    /**
     * O(n) iterates through collection until it finds a match
     */
    override fun contains(element: T): Boolean {
        for(node in this){
            if(node == element) return true
        }
        return false
    }

    /**
     * O(n^2), inefficient, iterates though each searched wor and checks O(n) contains searched
     *
     */
    override fun containsAll(elements: Collection<T>): Boolean {
        for(searchedNode in elements){
            if(!contains(searchedNode)){
                return true
            }
        }
        return false
    }


}
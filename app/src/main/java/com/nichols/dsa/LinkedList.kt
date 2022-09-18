package com.nichols.dsa

fun main() {
//    val list = LinkedList<Int>()
//    list.push(3).push(2).push(1)
//
//    //APPEND
//    list.append(1).append(2).append(3)
//    println("Before $list")
    //INSERT
//    var middleNode = list.nodeAt(1)!!
//    for(i in 1..3){
//        middleNode = list.insert(-1 * i, middleNode)
//    }
    //POP
//    val popped = list.pop()
//    println("Popped $popped")
    //REMOVE LAST
//    val removed = list.removeLast()
//    println("removed $removed")
    //REMOVE AFTER
//    val index = 4
//    val node = list.nodeAt(index - 1)!!
//    val removed = list.removeAfter(node)
//    println(removed)
//    for(node in list){
//        println("Double: ${node * 2}")
//    }
//    println("After $list")
    val list = LinkedList<Int>()
    list.add(5)
    list.add(4)
    list.add(3)
    list.add(2)
    list.add(1)
    println(list)
    list.printInReverse()
    val m = list.getMiddle()
    println(m?.value)
//    list.remove(1)
//    println("Removing nodes")
//    println(list)
//
//    list.retainAll(listOf(3,4,5))
//    println("retain 3,4 & 5")
//    println(list)
//
//    list.removeAll(listOf(3,4,5))
//    println("removed 3,4,5")
//    println(list)
}

/**
 * Tier 2, Iterable base
 */
class LinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T>{
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
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
    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun isEmpty(): Boolean = size == 0

    /**
     * Adds a value at the front of the list
     * Uses Fluent Interface pattern to chain calls to push
     */
    fun push(value: T): LinkedList<T>{
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
    fun append(value: T) : LinkedList<T>{
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
     * O(n)
     */
    override fun contains(element: T): Boolean {
        for(node in this){
            if(node == element) return true
        }
        return false
    }

    /**
     * O(n^2)
     */
    override fun containsAll(elements: Collection<T>): Boolean {
        for(node in this){
            if(!contains(node)) return false
        }
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for(node in elements){
            append(node)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()){
            val item = iterator.next()

            if(item == element){
                iterator.remove()
                return true
            }

        }
        return false
    }

    /**
     * Returns true if ANY element is removed
     * O(n^2) inefficient
     */
    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for(node in elements){
            result = remove(node) || false
        }
        return result
    }

    /**
     * O(n^2)
     */
    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while(iterator.hasNext()){
            val item = iterator.next()
            if(!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }
}

/**
 * List extension method,
 */
fun <T> LinkedList<T>.printInReverse(){
    this.nodeAt(0)?.printInReverse()
}

/**
 * Node extension method,O(n) since you have to travel in reverse n times
 */
fun <T> Node<T>.printInReverse() {
    this.next?.printInReverse()
    // If your not at the end of a list print -> seperator
    if(this.next != null){
        print(" -> ")
    }
    //as recursive statements unravel, the node data gets printed
    print(this.value.toString())
}

/**
 * fast called 2x as fast as slow
 * Once you've reached the end, slow is the middle node
 */
fun <T> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    while(fast != null) {
        fast = fast.next
        if(fast != null){
            fast = fast.next
            slow = slow?.next
        }
    }
    return slow
}


data class Node<T>(var value: T, var next: Node<T>? = null){
    override fun toString(): String {
        return if(next != null){
            "$value -> ${next.toString()}"
        } else "$value"
    }
}
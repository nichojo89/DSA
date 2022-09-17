package com.nichols.dsa

class LinkedListIterator<T>(private val list:  LinkedList<T>) : Iterator<T>, MutableIterator<T>{
    private var index = 0
    private var lastNode: Node<T>? = null

    /**
     * is index < size
     */
    override fun hasNext(): Boolean {
        return index < list.size
    }


    override fun next(): T {
        if(index >= list.size) throw IndexOutOfBoundsException()

        //Set lastNode to lasNode.next or head for first iteration
        //Iterator up
        lastNode = if(index == 0){
            list.nodeAt(0)
        } else {
            lastNode?.next
        }

        //Bump up index
        index++
        //return next node
        return lastNode!!.value
    }

    /**
     *
     */
    override fun remove() {
        if(index == 1){
            list.pop()
        } else {
            val prevNode = list.nodeAt(index - 2) ?: return

            //remove self
            list.removeAfter(prevNode)
            //assign last node
            lastNode = prevNode
        }
        index--
    }

}
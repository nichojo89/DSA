package com.nichols.dsa

class LinkedListIterator<T>(private val list:  LinkedListTierOne<T>) : Iterator<T>{
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

}
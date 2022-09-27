package com.nichols.dsa.collections

fun main() {
    val item = 8
    val index = 2
    var tables = intArrayOf(5,2,3,5,7)
    println("before")
    println(tables.joinToString(","))
    tables = insert(tables,index,item)
    println("Inserting $item at index $index")
    println(tables.joinToString(","))
}

/**
 * Inserts an element at index
 * O(n)
 */
fun insert(a: IntArray, index: Int, value: Int): IntArray{
    var b = a.copyOf()
    b +=0
    var size = b.size

    //tables += 8
    while(size > index){
        b[size-1] = b[size-2]

        //decrease
        size--
    }

    b[index] = value
    return b
}
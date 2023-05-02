package com.nichols.dsa.trie

fun main(){
    //ARRANGE
    val finder = ContactFinder()
    val A = intArrayOf(1,0,1,0,0)
    val B = arrayOf("Joe", "Claudio", "Justin", "Emily", "Nibs")

    //ACT
    val res = finder.solve(A,B)

    //ASSERT
    val ans = res == intArrayOf()
}
class ContactFinder {
    class TrieNode {
        val children = mutableMapOf<Char, TrieNode>()
        var isWordEnd = false
        var count = 0
    }
    private val root = TrieNode()

    fun solve(A: IntArray, B: Array<String>): IntArray {
        val result = mutableListOf<Int>()

        for (i in A.indices)
            if (A[i] == 0)
                add(B[i])
            else if (A[i] == 1)
                result.add(findPartialCount(B[i]))

        return result.toIntArray()
    }

    /**
     * Adds contact to
     */
    private fun add(contact: String) {
        var node = root
        for (char in contact) {
            //Add char to tree
            node.children.getOrPut(char) { TrieNode() }
            //Go to next node
            node = node.children[char]!!
            //Increment count of chars that have crossed this node
            node.count++
        }
        node.isWordEnd = true
    }

    /**
     * Searches for contact that starts with A
     */
    private fun findPartialCount(searchString: String): Int {
        var node = root
        for (char in searchString)
            node = node.children[char] ?: return 0
        
        return node.count
    }
}
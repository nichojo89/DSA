package com.nichols.dsa.dynamicprogramming

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode

class CircleDoubleLinked {
    fun solve(root : TreeNode): TreeNode {
        BTree2DoublyLinkedList(root!!)
        prev!!.right = head
        head!!.left = prev

        return root
    }
    var root: TreeNode? = null
    var head: TreeNode? = null
    var prev: TreeNode? = null

    fun BTree2DoublyLinkedList(root: TreeNode) {

        BTree2DoublyLinkedList(root.left)

        if (prev == null) head = root else {
            root.left = prev
            prev!!.right = root
        }
        prev = root

        BTree2DoublyLinkedList(root.right)
    }
}
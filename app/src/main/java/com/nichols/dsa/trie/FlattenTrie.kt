package com.nichols.dsa.trie

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode

fun flatten(a: TreeNode?): TreeNode? {
    if (a == null) return null
    if (a.left == null && a.right == null) return a
    if (a.left != null) {
        flatten(a.left)
        val tempNode: TreeNode = a.right
        a.right = a.left
        a.left = null
        var curr: TreeNode = a.right
        while (curr.right != null) curr = curr.right
        curr.right = tempNode
    }
    flatten(a.right)
    return a
}
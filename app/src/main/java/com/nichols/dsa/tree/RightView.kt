package com.nichols.dsa.tree

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode

fun solvasdasde(A: TreeNode): IntArray {
    val result = arrayListOf<Int>()
    leftView(A, result, 0)
    return result.toIntArray()
}

fun leftView(curr: TreeNode?, result: ArrayList<Int>, currDepth: Int) {
    if (curr == null) {
        return
    }
    if (currDepth == result.size) {
        result.add(curr.`val`)
    }
    leftView(curr.left, result, currDepth + 1)
    leftView(curr.right, result, currDepth + 1)
}
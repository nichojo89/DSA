package com.nichols.dsa.tree

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode


class MaxSumPath {
    class Res {
        var `val` = 0
    }
    var root: TreeNode? = null

    fun maxPathSum(A: TreeNode): Int {
        val res = Res()
        res.`val` = Int.MIN_VALUE
        findMaxUtil(A, res)
        return res.`val`
    }

    fun findMaxUtil(node: TreeNode?, res: Res): Int {
        if (node == null)
            return 0

        val l = findMaxUtil(node.left, res)
        val r = findMaxUtil(node.right, res)


        val max_single: Int = Math.max(Math.max(l, r) + node.`val`, node.`val`)

        val max_top = Math.max(max_single, l + r + node.`val`)

        res.`val` = Math.max(res.`val`, max_top)
        return max_single
    }
}
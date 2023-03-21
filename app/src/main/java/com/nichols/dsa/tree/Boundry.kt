package com.nichols.dsa.tree
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode

class Boundry {
    var root: TreeNode? = null
    val arr: ArrayList<Int> = arrayListOf()

    fun solve(A: TreeNode? ): IntArray {
        printBoundary(A)
        return arr.toIntArray()
    }

    private fun printBoundary(node: TreeNode?) {
        if (node == null)
            return
        arr.add(node.`val`)

        printBoundaryLeft(node.left)

        printLeaves(node.left)
        printLeaves(node.right)

        printBoundaryRight(node.right)
    }

    private fun printLeaves(node: TreeNode?) {
        if (node == null)
            return

        printLeaves(node.left)

        if (node.left == null && node.right == null)
            arr.add(node.`val`)

        printLeaves(node.right)
    }

    private fun printBoundaryLeft(node: TreeNode?) {
        if (node == null) return
        if (node.left != null) {
            arr.add(node.`val`)
            printBoundaryLeft(node.left)
        } else if (node.right != null) {
            arr.add(node.`val`)
            printBoundaryLeft(node.right)
        }
    }

    private fun printBoundaryRight(node: TreeNode?) {
        if (node == null)
            return

        if (node.right != null) {
            printBoundaryRight(node.right)
            arr.add(node.`val`)
        } else if (node.left != null) {
            printBoundaryRight(node.left)
            arr.add(node.`val`)
        }
    }
}
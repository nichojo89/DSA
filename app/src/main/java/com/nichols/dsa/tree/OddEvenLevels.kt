package com.nichols.dsa.tree

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode

fun solveOddEvenLevels(A: TreeNode? ): Int {
    if(A==null)
        return 0

    return A.`val` - solveOddEvenLevels(A.left) - solveOddEvenLevels(A.right)
}
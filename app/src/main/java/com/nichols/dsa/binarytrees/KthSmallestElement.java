package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class KthSmallestElement {
    public int isSameTree(TreeNode A, TreeNode B) {
        if(identicalTrees(A,B))
            return 1;
        else
            return 0;
    }

    TreeNode root1, root2;

    boolean identicalTrees(TreeNode a, TreeNode b)
    {
        if (a == null && b == null)
            return true;

        if (a != null && b != null)
            return (a.val == b.val
                    && identicalTrees(a.left, b.left)
                    && identicalTrees(a.right, b.right));

        return false;
    }
}
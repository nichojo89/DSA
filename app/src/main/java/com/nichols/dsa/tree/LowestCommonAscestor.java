package com.nichols.dsa.tree;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class LowestCommonAscestor {
    public Integer solveLowestCommonAncestor(TreeNode A, Integer B, Integer C) {
        if (A == null || A.val == B || A.val == C)
            return A.val;

        Integer left = solveLowestCommonAncestor(A.left, B, C);
        Integer right = solveLowestCommonAncestor(A.right, B, C);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return A.val;
    }
}

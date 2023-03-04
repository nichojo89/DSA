package com.nichols.dsa.tree;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class LCAinBST {
    public int solve(TreeNode A, int B, int C) {
        if(A == null)
            return 0;
        int curr = A.val;
        if(curr < B && curr < C) {
            return solve(A.right, B, C);
        }
        if(curr > B && curr > C) {
            return solve(A.left, B, C);
        }
        return A.val;
    }
}

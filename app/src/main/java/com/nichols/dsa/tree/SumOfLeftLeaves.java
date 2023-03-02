package com.nichols.dsa.tree;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class SumOfLeftLeaves {
    public int solveSumOfLeft(TreeNode A) {
        int res = 0;

        if(A != null){
            if(isLeaf(A.left))
                res += A.left.val;
            else
                res += solveSumOfLeft(A.left);

            res += solveSumOfLeft(A.right);
        }

        return res;
    }

    public boolean isLeaf(TreeNode A){
        if(A == null)
            return false;
        if(A.left == null && A.right == null)
            return true;
        return false;
    }
}

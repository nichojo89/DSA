package com.nichols.dsa.binarytrees;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class BSTValidator {
    public int isValidBST(TreeNode A) {
        if(isBST(A,Integer.MIN_VALUE,Integer.MAX_VALUE))
            return 1;
        else
            return 0;
    }

    public boolean isBST(TreeNode A, int L, int R){
        if(A==null)
            return true;

        if(A.val >= L && A.val <= R){
            boolean x = isBST(A.left, L, A.val - 1);
            boolean y = isBST(A.right, A.val+1,R);

            return x && y;
        }
        return false;
    }
}

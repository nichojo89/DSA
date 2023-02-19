package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class DeleteFromBST {

    public TreeNode solveDeleteFromBST(TreeNode A, int B) {
        if(A != null)
            if(B < A.val)
                A.left = solveDeleteFromBST(A.left, B);
            else if(B > A.val)
                A.right = solveDeleteFromBST(A.right, B);
            else{
                if(A.left == null && A.right == null)
                    return null;
                if (A.left == null || A.right == null)
                    return A.left != null ? A.left : A.right;

                TreeNode temp = A.left;
                while(temp.right != null)
                    temp = temp.right;
                A.val = temp.val;
                A.left = solveDeleteFromBST(A.left, temp.val);
            }
        return A;
    }
}

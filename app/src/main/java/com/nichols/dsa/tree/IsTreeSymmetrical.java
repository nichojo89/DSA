package com.nichols.dsa.tree;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class IsTreeSymmetrical {
    public int isSymmetric(TreeNode A) {
        return isMirror(A,A) ? 1 : 0;
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null)
            return true;
        if(t1==null || t2==null)
            return false;

        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}

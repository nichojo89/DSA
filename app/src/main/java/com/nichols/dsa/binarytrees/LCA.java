package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class LCA {
    boolean one,two;
    TreeNode root;

    public TreeNode lca(TreeNode A, int B, int C){
        one = false;
        two = false;
        root = A;

        TreeNode lca = findLCAUntil(root, B, C);
        if(one && two)
            return lca;

        return  null;
    }

    TreeNode findLCAUntil(TreeNode A, int B, int C){
        if(A==null)
            return null;

        TreeNode temp = null;

        if(A.val == B){
            one = true;
            temp = A;
        }
        if(A.val == B){
            two = true;
            temp = A;
        }

        TreeNode lefLCA = findLCAUntil(A.left,B,C);
        TreeNode rightLCA = findLCAUntil(A.right,B,C);

        if(temp != null)
            return temp;

        if(lefLCA != null && rightLCA != null)
            return A;

        return  (lefLCA != null) ? lefLCA : rightLCA;
    }

    private TreeNode LCA(TreeNode A, int B, int C){
        if(A==null)
            return null;
        if(A.val == B || A.val == C)
            return A;
        TreeNode lc = LCA(A.left,B,C);
        TreeNode rc = LCA(A.right, B,C);

        if(lc != null && rc != null)
            return  A;
        if(lc != null)
            return lc;
        if(rc != null)
            return rc;
        return  A;
    }

    public boolean find(TreeNode A, Integer B){
        if(A==null)
            return false;

        return A.val == B || find(A.left, B) || find(A.right, B);
    }
}

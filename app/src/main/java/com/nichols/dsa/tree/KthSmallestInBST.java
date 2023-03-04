package com.nichols.dsa.tree;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class KthSmallestInBST {
    public int kthsmallest(TreeNode A, int B) {
        TreeNode small=kthsmallestL(A,new int[]{B});
        return small.val;
    }

    private TreeNode kthsmallestL(TreeNode root,int k[])
    {
        if(root==null)
            return null;

        TreeNode left=kthsmallest(root.left,k);
        if(left!=null)
            return left;
        k[0]--;
        if(k[0]==0)
            return root;

        return kthsmallest(root.right,k);
    }
}

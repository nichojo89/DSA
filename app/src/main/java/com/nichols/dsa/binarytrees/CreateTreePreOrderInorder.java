package com.nichols.dsa.binarytrees;

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class CreateTreePreOrderInorder {
    public TreeNode buildTree(int[] A, int[] B) {
        return helper(0,0,B.length-1,A,B);
    }

    public TreeNode helper(
            int preStart,
            int inStart,
            int inEnd,
            int[] preorder,
            int[] inorder){
        if(preStart > preorder.length-1 || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int index = 0;
        for(int i=inStart; i <= inEnd; i++){
            if(root.val == inorder[i])
                index = i;
        }

        root.left = helper(preStart+1,inStart,index-1,preorder,inorder);
        root.right = helper(preStart+index-inStart+1,index+1,inEnd,preorder,inorder);
        return root;
    }
}
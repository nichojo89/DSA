package com.nichols.dsa.binarytrees;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

import java.util.HashMap;

public class CreateTreePostorderInorder {
    public TreeNode buildTree(int[] A, int[] B) {
        if(A == null || B == null || A.length != B.length)
            return null;

        HashMap<Integer,Integer> hm = new HashMap();

        for(int i = 0; i < A.length; i++)
            hm.put(A[i],i);

        return buildTreePostorderInorder(A,
                0,
                A.length-1,
                B,
                0,
                B.length-1,hm);
    }

    private TreeNode buildTreePostorderInorder(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> hm) {
        if(ps>pe || is>ie)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);

        int inRoot = hm.get(postorder[pe]);
        int numsLeft = inRoot - is;
        root.left = buildTreePostorderInorder(inorder,is,inRoot-1,
                                    postorder,ps,ps+numsLeft-1,hm);
        root.right = buildTreePostorderInorder(inorder,inRoot+1,ie,
                postorder,ps+numsLeft,pe-1,hm);
        return root;

    }
}

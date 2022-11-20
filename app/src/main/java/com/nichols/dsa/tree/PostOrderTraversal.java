package com.nichols.dsa.tree;

import java.util.ArrayList;

public class PostOrderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        return postOrderRecursive(A, new ArrayList<Integer>());
    }

    public ArrayList<Integer> postOrderRecursive(TreeNode A, ArrayList<Integer> B){
        if(A == null)
            return B;

        postOrderRecursive(A.left,B);
        postOrderRecursive(A.right,B);
        B.add(A.val);

        return B;
    }
}

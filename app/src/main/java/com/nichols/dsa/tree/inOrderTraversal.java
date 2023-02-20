package com.nichols.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode;

public class inOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {

    }
    public List<Integer> preorderTraversal(TreeNode A) {
        return preorderRecurssive(A, new List<Integer>());
    }

    public ArrayList<Integer> preorderRecurssive(TreeNode A, ArrayList<Integer> B) {
        if(A == null)
            return B;
        B.add(A.val);

        preorderRecurssive(A.left,B);
        preorderRecurssive(A.right,B);
        return B;
    }

}
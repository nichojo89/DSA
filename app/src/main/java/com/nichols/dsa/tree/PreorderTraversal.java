package com.nichols.dsa.tree;

import java.util.ArrayList;

public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        return preorderRecurssive(A, new ArrayList<Integer>());
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
       val = x;
      }
  }
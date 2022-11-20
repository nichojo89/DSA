package com.nichols.dsa.tree;

import java.util.ArrayList;

  class TreeNodew {
      int val;
      TreeNodew left;
      TreeNodew right;
      TreeNodew(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
public class PreorderTraversal {
//    public int solve(TreeNodew A) {
//        if(A == null)
//            return 0;
//
//        int l = solve(A);
//        int r = solve(A);
//
//        return Math.max(l,r.val);
//    }
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

//    public int solvasdasde(TreeNode A) {
//        if(A == null)
//            return 0;
//
//        int l = solvasdasde(A);
//        int r = solvasdasde(A);
//
//        return Math.max(l.val,r.val);
//    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
       val = x;
      }
  }

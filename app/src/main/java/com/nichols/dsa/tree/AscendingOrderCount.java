package com.nichols.dsa.tree;

public class AscendingOrderCount {
    public int solve(TreeNode A) {
        solveRecursive(A,Integer.MIN_VALUE);
        return count;
    }
    private int count;

    public void solveRecursive(TreeNode A, int B){
        if(A == null)
            return;

        if(A.val > B)
            count++;

        solveRecursive(A.left, Math.max(B, A.val));
        solveRecursive(A.right, Math.max(B,A.val));
    }
}

package com.nichols.dsa.binarytrees;
class Knapsack {
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        return knapSack(C, B, A, n);
    }

    static int max(int a, int b) { return Math.max(a, b); }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
        else
            return max(val[n - 1]
                            + knapSack(W - wt[n - 1], wt,
                            val, n - 1),
                    knapSack(W, wt, val, n - 1));
    }
}


public class BSTSearch {
    public int solve(DiameterOfTree.TreeNode A, int B) {
        DiameterOfTree.TreeNode temp = A;
        while(temp != null){
            if(temp.val == B)
                return 1;
            else if(temp.val < B)
                temp = temp.right;
            else
                temp = temp.left;
        }
        return 0;
    }
}

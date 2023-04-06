package com.nichols.dsa.dynamicprogramming;

public class MaxSumnValue {
    public int solve(int[] A, int B, int C, int D) {
        int n = A.length;
        int[] lft = new int[n];
        lft[0] = B * A[0];
        for(int i = 1; i < n; i++)
            lft[i] = Math.max(lft[i-1], B * A[i]);

        int[] right = new int[n];
        right[n-1] = D*A[n-1];
        for(int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], D * A[i]);

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++)
            ans = Math.max(ans, lft[i] + C*A[i] + right[i]);

        return ans;
    }
    static int maximizeExpr(int a[],  int B,
                            int C, int D)
    {
        // Traverse the whole array and compute
        // left maximum for every index.
        int L[] = new int[n];
        L[0] = B * a[0];
        for (int i = 1; i < n; i++)
            L[i] = Math.max(L[i - 1], B * a[i]);

        // Compute right maximum for every index.
        int R[] = new int[n];
        R[n - 1] = D * a[n - 1];
        for (int i = n - 2; i >= 0; i--)
            R[i] = Math.max(R[i + 1], D * a[i]);

        // Traverse through the whole array to
        // maximize the required expression.
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, L[i] + C * a[i] +
                    R[i]);

        return ans;
    }
}

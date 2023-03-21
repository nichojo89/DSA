package com.nichols.dsa.dynamicprogramming;

public class MaxSumWithoutAdjacentElements {
    public int adjacent(int[][] A) {
        int n = A.length;
        int inc = Math.max(A[0][0], A[1][0]);
        int excl = 0,excl_new;

        for(int i = 1; i < n; i++)
        {
            excl_new = Math.max(excl,inc);
            inc = excl + Math.max(A[0][1], A[1][i]);
            excl = excl_new;
        }
        return Math.max(excl, inc);
    }

    public static int maxSum(int A[][])
    {
        // Sum including maximum element of first
        // column
        int incl = Math.max(A[0][0], A[1][0]);

        // Not including first column's element
        int excl = 0, excl_new;

        // Traverse for further elements
        for (int i = 1; i < n; i++ )
        {
            // Update max_sum on including or
            // excluding of previous column
            excl_new = Math.max(excl, incl);

            // Include current column. Add maximum element
            // from both row of current column
            incl = excl + Math.max(A[0][i], A[1][i]);

            // If current column doesn't to be included
            excl = excl_new;
        }

        // Return maximum of excl and incl
        // As that will be the maximum sum
        return Math.max(excl, incl);
    }
}

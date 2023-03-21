package com.nichols.dsa.backtracking;

class UniquePathsIII {
    public int solve(int[][] A) {
        int m = A.length, n = A[0].length;
        int[] start = new int[2];
        int count = 0;//number of 0s and starting point
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(A[i][j]==1)
                {
                    start[0] = i;
                    start[1] = j;
                }
                else if(A[i][j]==0)
                    count++;
            }
        }
        return helper(A, start[0],start[1], count+1);
    }
    public int helper(int[][] grid,int i,int j, int count){
        if(i<0||j<0||i>=grid.length||j>=grid[i].length||grid[i][j]==-1)
            return 0;
        if(grid[i][j]==2)
        {
            if(count==0)
                return 1;
            return 0;
        }
        grid[i][j] = -1;
        int rst = 0;
        rst += helper(grid, i+1, j, count-1);
        rst += helper(grid, i-1, j, count-1);
        rst += helper(grid, i, j+1, count-1);
        rst += helper(grid, i, j-1, count-1);
        grid[i][j] = 0;
        return rst;
    }
}
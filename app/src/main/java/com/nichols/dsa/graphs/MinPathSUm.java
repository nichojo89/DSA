package com.nichols.dsa.graphs;

public class MinPathSUm {
    int[][] localMinPath;
    public int minPathSum(int[][] grid)
    {
        localMinPath = new int[grid.length][grid[0].length];
        //Starting point
        int x = grid.length - 1;
        int y = grid[0].length - 1;

        //Traverse the int array
        while (x >= 0 && y >= 0)
        {
            //Same row as x
            for (int i = x; i >= 0; i--)
                updateLocalMinPath(grid, i, y);

            //same column as Y
            for (int j = y - 1; j >= 0; j--)
                updateLocalMinPath(grid, x, j);

            /*
             * 4- Go to the next element on the diameter of the m*n matrix.
             */
            x --;
            y --;
        }

        return localMinPath[0][0];
    }



    void updateLocalMinPath(int[][] grid, int x, int y)
    {
        if (x == grid.length - 1)

        {
            if (y == grid[0].length - 1 )
                localMinPath [x][y] = grid [x][y];
            else
                localMinPath [x][y] = localMinPath [x][y+1] + grid [x][y] ;
        }
        else if (y == grid[0].length - 1)
            localMinPath [x][y] = localMinPath [x+1][y] + grid [x][y] ;
        else
            localMinPath [x][y] = Math.min(localMinPath [x][y+1], localMinPath [x+1][y]) + grid [x][y] ;
    }
}

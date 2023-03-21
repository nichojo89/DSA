package com.nichols.dsa.dynamicprogramming;

public class UniquePathsInAGrid {
    public int uniquePathsWithObstacles(int[][] A) {

        int r = A.length;
        int c = A[0].length;

        //Obstacle at start
        if(A[0][0] != 0)
            return 0;
        //start pos
        A[0][0] = 1;

        for(int j = 1; j < c; j++){
            if(A[0][j] == 0)
                A[0][j] = A[0][j-1];
            else
                A[0][j] = 0;
        }

        for(int i = 1; i <r; i++){
            if(A[i][0] == 0)
                A[i][0]  = A[i-1][0];
            else
                A[i][0] = 0;
        }

        for(int i = 1; i <r; i++){
            for(int j=1; j<c;j++)
                if(A[i][j] == 0)
                    A[i][j] = A[i][j-1] + A[i-1][j];
                else
                    A[i][j] = 0;
        }
        int[] j = A[r-1];
        return j[j.length-1];
    }
}

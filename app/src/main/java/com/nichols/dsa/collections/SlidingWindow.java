package com.nichols.dsa.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SlidingWindow {
    public int[][] generateMatrix(int A) {
        int[][] sourceArray = new int[A][A];
        ArrayList<int[]> resultArray = new ArrayList();
        //create sequential 2D Matrix
        int ii = 1;
        for(int i = 1; i <= A; i++){
            for(int j =1; j <= A; j++){
                sourceArray[i-1][j-1] = ii;
                ii++;
            }
        }
        //spiral iteration
        int i = 0;
        int j = 0;
        int n = sourceArray.length;

        //all except center cell for odd sized squares
        while(n > 1){
            //>>> top going right
            int[] right = new int[n-1];
            for(int k = 0; k < n-1; k++){
                right[k] = sourceArray[i][j];
                j++;
            }
            resultArray.add(right);

            //vvv right going down
            int[] down = new int[n-1];
            for(int k = 0; k < n-1; k++){
                down[k] = sourceArray[i][j];
                i++;
            }
            resultArray.add(down);

            //<<< bottom going left
            int[] left = new int[n-1];
            for(int k = 0; k < n-1; k++){
                left[k] = sourceArray[i][j];
                j--;
            }
            resultArray.add(left);

            //^^^ left going up
            int[] top = new int[n-1];
            for(int k = 0; k < n-1; k++){
                top[k] = sourceArray[i][j];
                i--;
            }
            resultArray.add(top);

            i++;
            j++;
            n -= 2;
        }
        //Get middle if its an odd aray
        if(n == 1)
            resultArray.add(new int[]{sourceArray[i][j]});

        int[][] G = resultArray.toArray(new int[0][0]);
        return G;
    }
}

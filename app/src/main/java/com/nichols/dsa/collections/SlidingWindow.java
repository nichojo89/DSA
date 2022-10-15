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
        Integer length = A;
        Integer direction = 0;
        ArrayList<Integer> row = new ArrayList();
        try {
            for(int d = 1; d <= (A*A); d++){
                if(j == 78){
                    int GG = 0;
                }
                int answ = sourceArray[i][j];
                row.add(answ);

                if(d == 75){
                    Integer f = 0;
                }
                switch (direction){
                    case 0: j++;//>>>
                    break;
                    case 1: i++;//vvv
                        break;
                    case 2: j--;
                        break;//<<<
                    case 3: i--;
                        break;///3^^^
                }
                //reached end of length
                if((row.size()+1) >= length){
                    //switched direction
                    if(direction == 3)
                    {
                        //We've completed a spiral
                        j++;
                        i++;
                        length -= 2;
                        direction = 0;
                    }
                    else
                        direction++;

                    int[] temp = new int[row.size()];
                    for(int y = 0; y < row.size(); y++){
                        temp[y] = row.get(y);
                    }
                    //TODO theres probably a better way than temp
                    row.clear();
                    resultArray.add(temp);
                    if(resultArray.size() == 8){
                        int H = 0;
                    }
                }
            }
        } catch (Exception e){
            int g = 0;
        }

        //TODO find a better way to do this
        int[][] temporary = new int[resultArray.size()][A-1];
        for(int k = 0; k < resultArray.size(); k++){
            temporary[k] = resultArray.get(k);
        }
        return temporary;
    }
    public ArrayList<ArrayList<Integer>> generateMatriAx(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int rows, cols;
        int row, col;
        rows = cols = A;

        for (int i = 0; i < rows; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < rows; j++) {
                res.get(i).add(0);
            }
        }
        row = col = 0;
        int dir = 0;
        int layer = 0;
        res.get(0).set(0, 1);
        for (int step = 2; step <= A * A; step++) {
            switch(dir) {
                // Go right
                case 0:
                    if (col == cols - layer - 1) {
                        row++;
                        dir = 1;
                    }
                    else
                        col++;
                    break;
                // Go down
                case 1:
                    if (row == rows - layer - 1) {
                        dir = 2;
                        col--;
                    } else
                        row++;
                    break;
                // Go left
                case 2:
                    if (col == layer) {
                        row--;
                        dir = 3;
                    } else
                        col--;
                    break;
                // Go up
                case 3:
                    if (row == layer + 1) {
                        dir = 0;
                        col++;
                        layer++;
                    } else
                        row--;
                    break;
            }
            res.get(row).set(col, step);
        }
        return res;
    }
}

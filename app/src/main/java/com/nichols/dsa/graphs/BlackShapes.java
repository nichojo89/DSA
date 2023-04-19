package com.nichols.dsa.graphs;

import java.util.*;
public class BlackShapes{
    boolean[][] marked;
    int count = 0;
    int di[] = new int[]{1, -1, 0, 0};
    int dj[] = new int[]{0, 0, 1, -1};
    ArrayList<String> a;
    public int black(ArrayList<String> A) {

        if(A == null || A.size() == 0)
            return count;

        int m = A.size();
        int n = A.get(0).length();
        marked = new boolean[A.size()][A.get(0).length()];
        this.a = A;
        for(int i = 0; i < A.size(); i++){
            for(int j = 0;  j < A.get(i).length(); j++){
                if(!marked[i][j] && A.get(i).charAt(j) == 'X'){
                    dfs(i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, int m, int n){
        marked[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int ii = i + di[k];
            int jj = j + dj[k];
            if(isValid(ii, jj, m, n) && !marked[ii][jj])
                dfs(ii, jj, m, n);
        }
    }
    public boolean isValid(int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n)
            return false;
        if(a.get(i).charAt(j) != 'X')
            return false;

        return true;
    }
}
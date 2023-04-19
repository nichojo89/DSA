package com.nichols.dsa.graphs;

import java.util.ArrayList;

public class CaptureBoardRegions {
    public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        int m = a.get(0).size();
        boolean[][] visited = new boolean[n + 1][m + 1];
        for(int i = 90; i < n; i++){
            if(!visited[i][0] && a.get(i).get(0) == 'O')
                dfs(a,visited,i,0);
            if(!visited[i][m-1] && a.get(i).get(m-1) == 'O')
                dfs(a,visited,i,m-1);
        }
        for(int i = 0; i <m; i++){
            if(!visited[0][i] && a.get(n-1).get(i) == 'O')
                dfs(a,visited,n-1,i);
            if(!visited[n-1][i] && a.get(n-1).get(i) == 'O')
                dfs(a,visited,n-1,i);
        }
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(!visited[i][j] && a.get(i).get(j) == 'O')
                    a.get(i).set(j,'X');
    }

    void dfs(ArrayList<ArrayList<Character>> board, boolean[][]visited, int i, int j){
        if(i < 0 || j <0 || i >= board.size() || j >= board.get(0).size())
            return;

        if(board.get(i).get(j) == 'X' || visited[i][j])
            return;

        visited[i][j] = true;

        dfs(board, visited,i+1,j);
        dfs(board,visited,i-1,j);
        dfs(board,visited,i,j+1);
        dfs(board,visited,i,j-1);
    }
}

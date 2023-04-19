package com.nichols.dsa.graphs;

import java.util.*;

public class FloydWarshall {
    public int[][] solve(int[][] A)
    {
        int n = A.length;
        int m = A[0].length;
        Queue<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (A[i][j] != 0) {
                    q.add(new Pair(i, j));
                    A[i][j] = 0;
                }
                else
                    A[i][j] = Integer.MAX_VALUE;

        int row[] = { -1, 1, 0, 0 };
        int col[] = {0, 0, -1, 1};
        while (q.size() != 0) {
            Pair top = q.peek();
            q.remove();
            int x = top.first;
            int y = top.second;
            int time = A[x][y];

            for (int i = 0; i < 4; i++) {
                int newx = x + row[i], newy = y + col[i];
                if (newx >= 0
                        && newx < n
                        && newy >= 0
                        && newy < m
                        && A[newx][newy] == Integer.MAX_VALUE) {

                    A[newx][newy] = time + 1;

                    q.add(new Pair(newx, newy));
                }
            }
        }
        return A;
    }

    class Pair {
        int first, second;
        Pair(int f, int s)
        {
            first = f;
            second = s;
        }
    }
}

package com.nichols.dsa.graphs;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.stream.IntStream;

public class FlyodWarshall {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[][] shortestPath(int[][] A) {
        int n = A.length;
        int[][] B = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[i][j];
                if (i != j && A[i][j] == -1) {
                    B[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        IntStream.range(0, n).parallel().forEach(k -> {
            IntStream.range(0, n).parallel().forEach(i -> {
                IntStream.range(0, n).parallel().forEach(j -> {
                    if (B[i][k] != Integer.MAX_VALUE && B[k][j] != Integer.MAX_VALUE
                            && B[i][k] + B[k][j] < B[i][j]) {
                        B[i][j] = B[i][k] + B[k][j];
                    }
                });
            });
        });

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (B[i][j] == Integer.MAX_VALUE)
                    B[i][j] = -1;

        return B;
    }

}

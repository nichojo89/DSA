package com.nichols.dsa.arrays;

import java.util.ArrayList;
import java.util.List;


public class MaxSubSumJava {
    public static int[][] preprocess(int[][] mat, int M, int N)
    {
        int[][] sum = new int[mat.length][mat[0].length];
        sum[0][0] = mat[0][0];

        for (int j = 1; j < mat[0].length; j++)
            sum[0][j] = mat[0][j] + sum[0][j - 1];

        for (int i = 1; i < mat.length; i++)
            sum[i][0] = mat[i][0] + sum[i - 1][0];

        for (int i = 1; i < mat.length; i++)
            for (int j = 1; j < mat[0].length; j++)
                sum[i][j] = mat[i][j] + sum[i - 1][j] + sum[i][j - 1]
                        - sum[i - 1][j - 1];

        return sum;
    }

    public int solveFindMaxSumSubMatrix(int[][] A, int B)
    {
        int ans = 0;
        if (A == null || A.length == 0)
            return ans;

        int M = A.length;
        int N = A[0].length;

        int[][] sum = preprocess(A, M, N);

        int total, max = Integer.MIN_VALUE;
        Point p = null;

        for (int i = B - 1; i < M; i++)
            for (int j = B - 1; j < N; j++)
            {
                total = sum[i][j];
                if (i - B >= 0)
                    total = total - sum[i - B][j];

                if (j - B >= 0)
                    total = total - sum[i][j - B];

                if (i - B >= 0 && j - B >= 0)
                    total = total + sum[i - B][j - B];

                if (total > max)
                {
                    max = total;
                    p = new Point(i, j);
                }
            }

        for (int i = 0; i < B; i++)
        {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < B; j++) {
                int r = i + p.first - B + 1;
                int c = j + p.second - B + 1;
//                row.add(A[r][c]);
                ans += A[r][c];
            }
//            System.out.println(row);
        }
        return ans;
    }
}

class Point
{
    int first, second;

    public Point(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

//class Main
//{
//    public static void main(String[] args)
//    {
//        // 5 × 5 matrix
//        int[][] mat =
//                {
//                        { 3, -4, 6, -5, 1 },
//                        { 1, -2, 8, -4, -2 },
//                        { 3, -8, 9, 3, 1 },
//                        { -7, 3, 4, 2, 7 },
//                        { -3, 7, -5, 7, -6 }
//                };
//
//        // submatrix size
//        int k = 3;
//
//        findMaxSumSubMatrix(mat, k);
//    }
//}

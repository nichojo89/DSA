package com.nichols.dsa.collections;

import java.util.ArrayList;

import kotlin.ranges.IntRange;

public class GenerateAllSubArrays {
    public long solve(int A, int[] B) {
        int n = B.length;
        long count = 0L;

        for(int i = 0; i < n; i++){
            for(int j =i; j < n; j++){
                int bitwise_or = 0;

                //traverse from i to j
                for(int k = i; k <= j; k++){
                    bitwise_or = bitwise_or | B[k];
                }
                if(bitwise_or >= 1)
                    count++;
            }

        }
        return count;
    }
    static void printSubArrays(int[] arr, int start, int end)
    {
        if (end == arr.length)
            return;
        else if (start > end)
            printSubArrays(arr, 0, end + 1);
        else {
            System.out.print("[");
            for (int i = start; i < end; i++)
                System.out.print(arr[i] + ", ");
            System.out.println(arr[end] + "]");
            printSubArrays(arr, start + 1, end);
        }
        return;
    }

    public int[][] solve(int[] A) {
        int n = A.length;
        int sum = n * (n+1)/2;
        int[][] arr = new int[sum][];
        int l = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int g = j-i+1;
                int count = 0;

                int[] sub = new int[g];
                for(int k = i; k <= j; k++){
                    sub[count] = A[k];
                    count++;
                }
                arr[l] = sub;
                l++;
            }
        }
        return arr;
    }
}


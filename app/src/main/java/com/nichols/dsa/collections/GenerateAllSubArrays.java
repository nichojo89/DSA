package com.nichols.dsa.collections;

import java.util.ArrayList;

import kotlin.ranges.IntRange;

public class GenerateAllSubArrays {
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


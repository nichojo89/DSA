package com.nichols.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class FinishMaxJobs {
    public  int solve(int[] A, int[] B) {
        int n = A.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = B[i];  // finish time
            jobs[i][1] = A[i];  // start time
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int endTime = -1;
        for (int[] job : jobs) {
            if (job[1] >= endTime) {
                count++;
                endTime = job[0];
            }
        }
        return count;
    }
}

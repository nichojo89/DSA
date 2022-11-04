package com.nichols.dsa.sorting;

import java.util.Arrays;

public class NobileElements {
    public int solve(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int smaller = 0;
        int ans = 0;

        if(A[0] == 0){
            ans++;
        }

        for(int i  = 0; i < n; i++){
            if(A[i] != A[i-1])
                smaller = i;
            if(A[i] == smaller)
                ans++;
        }
        return ans;
    }
}

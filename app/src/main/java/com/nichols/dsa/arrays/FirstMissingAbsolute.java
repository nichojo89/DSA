package com.nichols.dsa.arrays;

public class FirstMissingAbsolute {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        //sort array
        for(int i = 0; i < n; i++){
            while(A[i] > 0 && A[i] <= n && A[i] != i+1){
                int temp = A[i];

                if(temp == A[temp - 1])
                    break;

                A[i] = A[temp-1];
                A[temp-1] = temp;
            }
        }
        //find first missing natural numbers
        for(int i = 0; i < n; i++){
            if(A[i] != i+1)
                return i+1;
        }

        return n+1;
    }
}

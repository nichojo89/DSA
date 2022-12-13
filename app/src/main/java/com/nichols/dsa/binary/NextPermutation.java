package com.nichols.dsa.binary;

import java.util.Arrays;

public class NextPermutation {
    public int[] nextPermutation(int[] A) {
        if(A.length<2)
            return A;

        int first = -1;

        for(int i = A.length-2; i >=0; i--){
            if(A[i]<A[i+1]){
                first = i;
                break;
            }
        }

        if(first !=-1){
            int t = -1;
            for(int i = first+1; i< A.length; i++){
                if(A[i]>A[first])
                    t = t!=-1 && A[t]<A[i]?t:i;
                else
                    break;
            }

            int c = A[t];
            A[t] = A[first];
            A[first] = c;
        }
        reverse(A,first+1);
        return A;
    }

    void reverse(int a[], int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }
}

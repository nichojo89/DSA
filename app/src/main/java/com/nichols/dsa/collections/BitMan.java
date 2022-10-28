package com.nichols.dsa.collections;

public class BitMan {
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
                if(bitwise_or >= A)
                    count++;
            }

        }
        return count;
    }
}

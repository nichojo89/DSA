package com.nichols.dsa.binary;

public class BitMan {
    public int solve(int[] A, int B) {
        long ans = 0;
        long t = 1;
        int n = A.length;

        for(int i = n-1; i >= 0;i--){
            ans = (ans + A[i] * t) % B;
            t = (t*10) % B;
        }
        return (int)ans;
    }
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
    public int solve(int A) {

        if(A==0) return 0;
        if(A==1) return 1;

        int samCount=1;
        int score=1;

        while(score!=A)
        {
            int tempScore=score*2;

            if(tempScore>A)
            {
                score=score+1;
                samCount++;
            }
            else
            {
                score=tempScore;
            }
        }
        return samCount;
    }

//    public int solve(int A, int B, int C) {
//        long ans = 1L;
//        for(int i =  1; i <= B; i++){
//            ans = ans * A;
//        }
//        return Integer.valueOf(ans % new Long(C));
//    }
}

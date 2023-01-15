package com.nichols.dsa.binary_search;

public class FindMedianMatrix {
    public int findMedian(int[][] A) {
        int l = 0;
        int r = 0;
        int n = A.length;
        int m = A[0].length;
        int mid;
        int req = (n*m)/2+1;
        for(int k = 0; k < n; k++)
            r = Math.max(r,A[k][m-1]);

        int ans = -1;
        while(l <= r){
            mid = l +(r-l)/2;
            int count = 0;
            for(int row = 0; row < n; row++){
                int p  = countAvg(A[row],mid);
                count += p;
            }

            if(count >= req){
                ans = mid;
                r = mid-1;
            } else
                l = mid+1;
        }
        return ans;
    }
    public int countAvg(int[] A, int B) {
        int i = 0;
        int j = A.length - 1;
        int ans = -1;
        while(i <= j){
            int m = (i+j)/2;
            if(A[m] > B){
                ans = m;
                j = m-1;
            } else
                i = m+1;
        }
        if(ans == -1)
                return A.length;
        return ans;
    }
}

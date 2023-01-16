package com.nichols.dsa.binary_search;

public class BinarySearchSqrt {
    public int sqrt(int A) {
        if(A == 0)
            return 0;

        int left = 1;
        int right = A;
        int ans = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(mid <= A/mid){
                ans = mid;
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return ans;
    }
}

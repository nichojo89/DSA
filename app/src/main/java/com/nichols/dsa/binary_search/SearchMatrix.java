package com.nichols.dsa.binary_search;

public class SearchMatrix {
    public int searchMatrix(int[][] A, int B) {
        int low = 0;
        int m = A[0].length;
        int high = A.length * m-1;
        
        while(low <= high){
            int mid = (high+low)/2;
            int i = mid/m;
            int j = mid%m;
            if(A[i][j] == B)
                return 1;
            else if(A[i][j] < B)
                low = mid+1;
            else
                high = mid-1;
        }
        return 0;
    }
}

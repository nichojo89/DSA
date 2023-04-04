package com.nichols.dsa.dynamicprogramming;

public class BuyStocks {
    public int maxProfit(final int[] A) {
        int profit = 0;
        int n = A.length;
        int max_ele = A[n-1];

        for(int i = n-2; i >=0; i--){
            max_ele = Math.max(A[i],max_ele);
            if(max_ele - A[i] > profit)
                profit = max_ele - A[i];
        }
        return profit;
    }
}

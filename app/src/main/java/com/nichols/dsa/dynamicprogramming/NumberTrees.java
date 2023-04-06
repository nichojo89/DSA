package com.nichols.dsa.dynamicprogramming;

public class NumberTrees {
    public int numTrees(int A) {
        int ans = 0;
        for(int i =0; i <=A; i++){
            ans = ans*(2*A-i);

        }
    }
}

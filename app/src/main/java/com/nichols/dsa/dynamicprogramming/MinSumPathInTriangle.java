package com.nichols.dsa.dynamicprogramming;

import java.util.ArrayList;

public class MinSumPathInTriangle {
    public int solve(int A, int B) {
        int ans = 0;

        for (int i = 1; i <= 9; i++)
            if (B-i >= 0)
                ans += countRec(A-1, B-i);

        return ans;
    }

    static int countRec(int n, int sum)
    {
        if (n == 0)
            return sum == 0 ?1:0;

        if (sum == 0)
            return 1;

        int ans = 0;

        for (int i=0; i<=9; i++)
            if (sum-i >= 0)
                ans += countRec(n-1, sum-i);

        return ans;
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int[] m = new int[a.size()];
        int n = a.size()-1;

        //Bottom row
        for(int i = 0;  i < a.get(n).size(); i++)
            m[i] = a.get(n).get(i);

        for(int i = a.size()-2; i >= 0; i--)
            for(int j = 0; j < a.get(i).size(); j++)
                m[j] = a.get(i).get(j) +
                        Math.min(m[j],m[j+1]);

        return m[0];
    }
}

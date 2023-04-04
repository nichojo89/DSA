package com.nichols.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class RegularExpressionMatch {
    public int isMatch(String A, String B) {
        boolean[] prev = new boolean[A.length() + 1];
        boolean[] curr = new boolean[A.length() + 1];

        prev[0] = true;

        for (int i = 1; i <= B.length(); i++) {
            boolean flag = true;
            for (int ii = 1; ii < i; ii++)
                if (B.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }

            curr[0] = flag;

            for (int j = 1; j <= A.length(); j++) {
                if (B.charAt(i - 1) == '*')
                    curr[j] = curr[j - 1] || prev[j];
                else if (B.charAt(i - 1) == '?'
                        || A.charAt(j - 1) == B.charAt(i - 1))
                    curr[j] = prev[j - 1];
                else
                    curr[j] = false;
            }
            prev = Arrays.copyOf(curr, curr.length);
        }

        if(prev[A.length()])
            return 1;
        else return 0;
    }
}

class Knapsack {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int n = A.size();
        int mxval = 50 * n;
        int[] dp = new int[mxval + 1];
        Arrays.fill(dp, 1000000000);

        for (int i = 0; i < n; i++) {
            for (int val = mxval; val >= A.get(i); val--) {
                dp[val] = Math.min(dp[val], B.get(i) + dp[val - A.get(i)]);
            }
        }

        int ans = 0;
        for (int val = mxval; val >= 0; val--) {
            if (dp[val] <= C) {
                ans = val;
                break;
            }
        }

        return ans;
    }

}

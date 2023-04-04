package com.nichols.dsa.dynamicprogramming;

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

package com.nichols.dsa.dynamicprogramming;

import java.util.HashMap;

public class CoinSum {
    public int minCut(String A) {
        HashMap<String, Integer> memo = new HashMap<>();
        return minpalparti_memo(A, 0, A.length() - 1, memo);
    }
    static boolean ispalindrome(String input, int start, int end)
    {
        while (start < end) {
            if (input.charAt(start) != input.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    static String convert(int a, int b)
    {
        return a + "" + b;
    }

    static int minpalparti_memo(String input, int i, int j, HashMap<String, Integer> memo)
    {
        if (i > j)
            return 0;

        String ij = convert(i, j);

        if (memo.containsKey(ij)) {
            return memo.get(ij);
        }

        if (i == j) {
            memo.put(ij, 0);
            return 0;
        }
        if (ispalindrome(input, i, j)) {
            memo.put(ij, 0);
            return 0;
        }
        int minimum = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int left_min = Integer.MAX_VALUE;
            int right_min = Integer.MAX_VALUE;
            String left = convert(i, k);
            String right = convert(k + 1, j);


            if (memo.containsKey(left)) {
                left_min = memo.get(left);
            }

            if (memo.containsKey(right)) {
                right_min = memo.get(right);
            }


            if (left_min == Integer.MAX_VALUE)
                left_min = minpalparti_memo(input, i, k, memo);
            if (right_min == Integer.MAX_VALUE)
                right_min = minpalparti_memo(input, k + 1, j, memo);

            minimum = Math.min(minimum, left_min + 1 + right_min);
        }

        memo.put(ij, minimum);

        return memo.get(ij);
    }


}

package com.nichols.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;



public class LetterCombos {
    public int solve(final int[] A) {
        int flag = 1;
        int n = A.length;
        int[][] dp = new int[2000][2000];

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += A[i];

        for (int i = -sum; i <= sum; i++) {
            try {
                dp[0][i] = Integer.MAX_VALUE;
            }
            catch (Exception e) {
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                try {
                    dp[flag][j] = Integer.MAX_VALUE;
                    if (j - A[i - 1] <= sum
                            && j - A[i - 1] >= -sum)
                        dp[flag][j]
                                = dp[flag ^ 1][j - A[i - 1]];
                    if (j + A[i - 1] <= sum
                            && j + A[i - 1] >= -sum
                            && dp[flag ^ 1][j + A[i - 1]]
                            != Integer.MAX_VALUE)
                        dp[flag][j] = Math.min(
                                dp[flag][j],
                                dp[flag ^ 1][j + A[i - 1]] + 1);
                }
                catch (Exception e) {
                }
            }

            flag = flag ^ 1;
        }

        for (int i = 0; i <= sum; i++) {
            if (dp[flag ^ 1][i] != Integer.MAX_VALUE)
                return dp[flag ^ 1][i];
        }

        return n - 1;
    }
    private final HashMap<Integer,String> _charMap = new HashMap<>();

    public String[] letterCombinations(String A) {
        _charMap.put(0,"0");
        _charMap.put(1,"1");
        _charMap.put(2,"abc");
        _charMap.put(3,"def");
        _charMap.put(4,"ghi");
        _charMap.put(5,"jkl");
        _charMap.put(6,"mno");
        _charMap.put(7,"pqrs");
        _charMap.put(8,"tuv");
        _charMap.put(9,"wxyz");
        ArrayList<String> ans = new ArrayList<>();

        ans = generateHelper("",0,A,ans);
        return ans.toArray(new String[0]);
    }

    private ArrayList<String> generateHelper(String current, int index, String digits, ArrayList<String> ans){
        if(index == digits.length()){
            ans.add(current);
            return ans;
        }
        int digit = digits.charAt(index) - '0';
        _charMap.get(digit).length();
        for(int i = 0; i < _charMap.get(digit).length(); i++){
            current += _charMap.get(digit).charAt(i);
            generateHelper(current, index+1,digits,ans);
            current = removeLastChar(current);
        }
        return ans;
    }

    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }
}

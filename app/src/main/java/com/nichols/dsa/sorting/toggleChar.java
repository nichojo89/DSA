package com.nichols.dsa.sorting;

public class toggleChar {
    public String solve(String A) {
        int n = A.length();
        StringBuilder str = new StringBuilder(A);

        for(int i = 0; i < n; i++){
            char r = (char)(A.charAt(i) ^ 32);
            str.setCharAt(i, r);
        }
        return str.toString();
    }

}

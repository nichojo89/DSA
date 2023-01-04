package com.nichols.dsa.prime;

public class FunFact {
    private int _mod = 1000007;

    public int findRank(String A) {
        String s = A;
        int ans = 0;
        int n = s.length();

        for(int i = 0; i < n-1; i++){
            int count = 0;

            for(int j = i+1; j < n; j++)
                if(s.charAt(j) == s.charAt(i))
                    count++;

            ans += (count * fact(n-i-1)) % _mod;
        }

        return (ans+1)%_mod;
    }

    public int fact(int n) {
        if(n==0 || n==1)
            return 1;
        else
            return (n * fact(n-1)) % _mod;
    }
}

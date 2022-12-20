package com.nichols.dsa.modular_arithmatic;

public class VeryLargePowerJava {
    public int solveVeryLargePowerJava(int A, int B) {
        long fact = 1L;
        long mod = Double.valueOf(1e9 + 7).longValue();

        for(long i = 2L; i <= B; i += 1)
            fact = (fact * i) % (mod - 1);

        int ans = fastPower(A,fact,mod);
        return ans;
    }

    public int fastPower(int A, long B,long mod){
        long ans = 1;
        while(B > 0){
            if((B & 1) == 1){
                ans = (ans * A) %mod;
            }

            A = (int) ((A % mod * A % mod) % mod);
            B = B >> 1;
        }

        return (int) (ans % mod);
    }
}

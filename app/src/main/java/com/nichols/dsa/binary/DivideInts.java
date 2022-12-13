package com.nichols.dsa.binary;

public class DivideInts {
    public int divide(int A, int B) {
        if(B == -2147483648)
            return 2147483647;
        long n= A, m = B;

        int sign = 1;
        if(n < 0)
            sign = -sign;

        if(m < 0)
            sign = -sign;

        n = Math.abs(n);
        m = Math.abs(m);

        long q = 0;

        for(int i = 31; i >=0; i--){
            if ((m << i) <= n){
                n -= (m << i);
                q += (1 << i);
            }
        }

        if(sign < 0)
            q = -q;

        if(q > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)q;
    }
}

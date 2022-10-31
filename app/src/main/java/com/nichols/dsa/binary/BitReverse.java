package com.nichols.dsa.binary;

public class BitReverse {
    public long reverse(long a) {
        int sizeOfInt = 32;
        long reverse = 0;
        for (int position = sizeOfInt - 1; position > 0; position--) {
            reverse += ((a & 1) << position);
            a >>= 1; }
        return reverse;
    }

}

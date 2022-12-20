package com.nichols.dsa.arrays;

import java.util.ArrayList;

public class RearrangeArray {
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for(int i = 0; i < n; i++){
            int A = a.get(i);
            A += (a.get(A) % n) * n;
            a.set(i,A);
        }

        for(int i = 0; i < n; i++){
            int A = a.get(i);
            a.set(i,A/n);
        }
    }
}

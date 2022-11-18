package com.nichols.dsa.binary;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TEST {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int solve(int[] A, int B) {
        Map<Integer, Integer> freqMap = new HashMap();
        final int mod = (int)(1e9 + 7);
        long ans = 0;
        for(int i = 0 ; i < A.length ; i++){
            if(freqMap.containsKey(B - A[i])){
                ans = (ans + freqMap.get(B - A[i])) % mod;
            }
            freqMap.put(A[i], freqMap.getOrDefault(A[i], 0) + 1);
        }
        return (int)(ans);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int solvePairSumDif(int[] A, int B){
        Map<Integer, Integer> freqMap = new HashMap();
        final int mod = (int)(1e9 + 7);
        long ans = 0;
        for(int i = 0; i < A.length; i++){
            if(freqMap.containsKey(B - A[i])){
                ans = (ans + freqMap.get(B - A[i]));
            } else if(freqMap.containsKey(B + A[i]))
                ans = (ans + freqMap.get(B + A[i]));

            freqMap.put(A[i], freqMap.getOrDefault(A[i],0)+1);
        }
        return (int)ans;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int solveFUCK(int[] A, int B) {
        Map<Integer, Integer> freq = new HashMap();
        final int mod = (int)(1e9 + 7);
        long ans = 0;
        for(int i = 0 ; i < A.length ; i++){
            ans += freq.getOrDefault(A[i] - B, 0) + freq.getOrDefault(A[i] + B, 0);
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        return (int)(ans % mod);
    }
}
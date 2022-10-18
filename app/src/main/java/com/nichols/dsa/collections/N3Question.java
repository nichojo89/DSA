package com.nichols.dsa.collections;

import java.util.List;

public class N3Question {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int n = a.size();
        int freqA = 0;
        int freqB = 0;

        int elemA = Integer.MIN_VALUE;
        int elemB = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            //carry forward the first element and check for a match
            if(elemA == a.get(i))
                freqA++;
            //carry forward the second element and check for a match
            else if(elemB == a.get(i))
                freqB++;
            //reset matches for first element
            else if(freqA == 0){
                freqA++;
                elemA = a.get(i);
            }
            //reset matches for second element
            else if(freqB == 0){
                freqB++;
                elemB = a.get(i);
            }
            else {
                freqA--;
                freqB--;
            }
        }
        freqA = 0;
        freqB = 0;

        //get count of most frequent 2 numbers
        for(int i = 0; i < n;i++){
            if(a.get(i) == elemA)
                freqA++;
            else if(a.get(i) == elemB)
                freqB++;
        }

        if(freqA > n / 3)
            return elemA;
        if(freqB > n / 3)
            return elemB;
        return -1;
    }
}

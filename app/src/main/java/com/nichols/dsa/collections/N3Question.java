package com.nichols.dsa.collections;

import java.util.List;

public class N3Question {
    public int solve(int A, int B) {
        String result = "";

        int lastQuotient = 0;

        for(int operatingNumber = A;operatingNumber > B; operatingNumber = operatingNumber/B) {
            result = getRepresantationOfLowIntValue(operatingNumber%B) + result;
            lastQuotient = operatingNumber/B;
        }

        result = getRepresantationOfLowIntValue(lastQuotient) + result;

        return Integer.parseInt(result);
    }
    private static String getRepresantationOfLowIntValue(int toConvert) {
        if(toConvert >= 0 && toConvert < 10) {
            return "" + toConvert;
        }

        switch(toConvert) {
            case 10 : return "A";
            case 11 : return "B";
            case 12 : return "C";
            case 13 : return "D";
            case 14 : return "E";
            case 15 : return "F";
        }

        return "Error, cannot transform number < 0 or > 15";
        //throw new IllegalArgumentException("cannot transform number < 0 or >15");
    }
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

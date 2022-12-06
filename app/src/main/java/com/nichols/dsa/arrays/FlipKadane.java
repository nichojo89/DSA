package com.nichols.dsa.arrays;

import java.util.ArrayList;

public class FlipKadane {
    public int[] flip(String A) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int c = 0; c < A.length(); c++){
            if(A.charAt(c) == '1')
                arr.add(-1);
            else
                arr.add(0);
        }

        int curr = 0;
        int best = 0;
        int l = 0;
        int r = -1;
        int idx = 0;

        for(int i =0; i < arr.size(); i++){
            curr += arr.get(i);
            if(curr < 0){
                curr = 0;
                idx = i+1;
            } else if (curr > best){
                //new best
                l = idx;
                r = i;
                best = curr;
            }
        }
        if(r != -1)
            return new int[]{1,2};
        else
            return new int[0];
    }
}

//        for(i in arr.indices){
    //        curr += arr[i]
    //        if(curr < 0){
    //        curr = 0
    //        idx = i+1
    //        } else if(curr > best){
    //        //new best
    //        l = idx
    //        r = i
    //        best = curr
    //        }
//        }
//
//        return if(r != -1) intArrayOf(l+1,r+1) else intArrayOf()
//        }

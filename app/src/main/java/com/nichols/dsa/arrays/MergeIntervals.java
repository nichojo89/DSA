package com.nichols.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public ArrayList<Interval> mergeIntervals(ArrayList<Interval> arr)
    {
        ArrayList<Interval> ans = new ArrayList();
        Collections.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start - i2.start;
            }
        });

        int index = 0;
        int n = arr.size();

        Interval curr = arr.get(0);
        for (int i=1; i<arr.size(); i++)
        {
            Interval prev = arr.get(i-1);
            curr = arr.get(i);


            if(prev.end < curr.start){
                //non-overlapping
                ans.add(prev);
            } else if(prev.start > curr.end){
                ans.add(curr);
                for(int j = i; j < n; j++){
                    ans.add(prev);
                }
                return ans;
            } else {
                curr.start = Math.min(prev.start,curr.start);
                curr.end = Math.max(prev.end,curr.end);
            }
        }
        ans.add(curr);
        return ans;
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        ArrayList<Interval> ans = new ArrayList();
        for(int i = 0; i < n; i++){
            if(intervals.get(i).end < newInterval.start){
                //non-overlapping
                ans.add(intervals.get(i));
            } else if(intervals.get(i).start > newInterval.end){
                ans.add(newInterval);
                for(int j = i; j < n; j++){
                    ans.add(intervals.get(j));
                }
                return ans;
            } else {
                newInterval.start = Math.min(intervals.get(i).start,newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end,newInterval.end);
            }
        }
        ans.add(newInterval);
        return ans;
    }
}


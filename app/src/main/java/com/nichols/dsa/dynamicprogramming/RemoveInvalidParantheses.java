package com.nichols.dsa.dynamicprogramming;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;

class Solution {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[][] subsetsWithDup(int[] A) {
        Arrays.sort(A);
        List<Integer> subset = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        subsetsUtil(A, result, subset, 0);
        int[][] answer = new int[result.size()][];
        int i = 0;
        for(List<Integer> it : result){
            answer[i] = it.stream().mapToInt(Integer::intValue).toArray();
            i++;
        }
        return answer;
    }

    public void subsetsUtil(int[] nums, Set<List<Integer>> result, List<Integer> subset, int index) {
        result.add(new ArrayList<>(subset));
        for(int i = index; i < nums.length; i++){
            subset.add(nums[i]);
            subsetsUtil(nums, result, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}

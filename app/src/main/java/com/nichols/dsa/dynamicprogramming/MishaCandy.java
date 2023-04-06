package com.nichols.dsa.dynamicprogramming;

import java.util.*;

public class MishaCandy {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= B) {
                pq.add(A[i]);
            }
        }

        int eaten = 0;
        while (!pq.isEmpty()) {
            int minCandies = pq.poll();
            if (pq.isEmpty()) {
                eaten += minCandies;
                break;
            }
            int nextMinCandies = pq.poll();
            eaten += Math.floor(minCandies / 2);
            int remainingCandies = (int) (minCandies - Math.floor(minCandies / 2));
            pq.add(remainingCandies + nextMinCandies);
        }

        return eaten;
    }
}
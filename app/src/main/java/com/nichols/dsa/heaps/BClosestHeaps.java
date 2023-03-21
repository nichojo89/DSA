package com.nichols.dsa.heaps;

import java.util.*;


public class BClosestHeaps {
    static class HeapNode
    {

        // Value to be stored
        int val;

        // Row number of value in 2D array
        int r;

        // Column number of value in 2D array
        int c;

        HeapNode(int val, int r, int c)
        {
            this.val = val;
            this.c = c;
            this.r = r;
        }
    }

    static void minHeapify(HeapNode harr[], int i, int heap_size)
    {
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if(l < heap_size&& r<heap_size && harr[l].val < harr[i].val && harr[r].val < harr[i].val){
            HeapNode temp=harr[r];
            harr[r]=harr[i];
            harr[i]=harr[l];
            harr[l]=temp;
            minHeapify(harr ,l,heap_size);
            minHeapify(harr ,r,heap_size);
        }
        if (l < heap_size && harr[l].val < harr[i].val){
            HeapNode temp=harr[i];
            harr[i]=harr[l];
            harr[l]=temp;
            minHeapify(harr ,l,heap_size);
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> A, int B)
    {
        int n = A.size();
        if (B < 0 && B >= n * n)
            return Integer.MAX_VALUE;

        HeapNode harr[] = new HeapNode[n];

        for(int i = 0; i < n; i++)
            harr[i] = new HeapNode(A.get(0).get(i), 0, i);

        HeapNode hr = new HeapNode(0, 0, 0);

        for(int i = 1; i <= B; i++)
        {
            hr = harr[0];

            int nextVal = hr.r < n - 1
                    ? A.get(hr.r + 1).get(hr.c)
                    : Integer.MAX_VALUE;

            harr[0] = new HeapNode(nextVal, hr.r + 1, hr.c);
            minHeapify(harr, 0, n);
        }

        return hr.val;
    }

}

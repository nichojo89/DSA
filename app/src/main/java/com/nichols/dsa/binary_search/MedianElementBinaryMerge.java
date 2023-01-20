package com.nichols.dsa.binary_search;

import java.util.Arrays;
import java.util.List;

public class MedianElementBinaryMerge {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n = a.size();
        int m = b.size();
        if (n > m)
            return findMedianSortedArrays(b, a);

        int start = 0;
        int end = n;
        int median = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = median - mid;
            int leftA = (leftAsize > 0)
                    ? a.get(leftAsize - 1)
                    : Integer.MIN_VALUE;

            int leftB = (leftBsize > 0)
                    ? b.get(leftBsize - 1)
                    : Integer.MIN_VALUE;

            int rightA = (leftAsize < n)
                    ? a.get(leftAsize)
                    : Integer.MAX_VALUE;

            int rightB = (leftBsize < m)
                    ? b.get(leftBsize)
                    : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
            else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
    }
}

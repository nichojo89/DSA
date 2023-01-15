package com.nichols.dsa.binary_search;

public class FindElement {
    public int solve(int[] A) {
        int index = findPeakElement(A,0A.length-1);
        return A[index];
    }
    public static int findPeakElement(int[] A, int left, int right)
    {
        int mid = (left + right) / 2;

        // Is middle peak?
        if ((mid == 0 || A[mid - 1] <= A[mid]) && (mid == A.length - 1 || A[mid + 1] <= A[mid]))
            return mid;

        if (mid - 1 >= 0 && A[mid - 1] > A[mid])
            return findPeakElement(A, left, mid - 1);

        return findPeakElement(A, mid + 1, right);
    }
    public int[] searchRange(final int[] A, int B) {
        int n = A.length;
        int first = first(A, 0, n - 1, B, n);
        int last = last(A, 0, n - 1, B, n);

        int[] ans = new int[2];
        ans[0] = first;
        ans[1] = last;
        return ans;
    }

    public static int first(int A[], int low, int high, int x, int n)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || x > A[mid - 1])
                    && A[mid] == x)
                return mid;
            else if (x > A[mid])
                return first(A, (mid + 1), high, x, n);
            else
                return first(A, low, (mid - 1), x, n);
        }
        return -1;
    }

    public static int last(int A[], int low, int high, int x, int n)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == n - 1 || x < A[mid + 1])
                    && A[mid] == x)
                return mid;
            else if (x < A[mid])
                return last(A, low, (mid - 1), x, n);
            else
                return last(A, (mid + 1), high, x, n);
        }
        return -1;
    }

    public static int search(int[] A)
    {
        int start = 0;
        int end = A.length - 1;
        int mid;
        //edge case
        if (A.length == 1)
            return A[0];

        if (A[start] != A[start + 1])
            return A[start];

        if (A[end] != A[end - 1])
            return A[end];

        // ninary search
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1])
                return A[mid];
            else if ((A[mid] == A[mid + 1] && mid % 2 == 0) || (A[mid] == A[mid - 1] && mid % 2 != 0))
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }
}

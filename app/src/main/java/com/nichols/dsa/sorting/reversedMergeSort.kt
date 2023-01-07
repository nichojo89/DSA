package com.nichols.dsa.sorting

class reversedMergeSort {
    fun solve(A: IntArray): Int{
        val n = A.size

        if(n < 2)
            return 0

        val mid = n/2
        val left = IntArray(mid)
        val right = IntArray(n - mid)
        for(i in 0 until mid)
            left[i] = A[i]
        for(j in mid until n)
            right[j - mid] = A[j]

        var leftCount = solve(left)
        var rightCount = solve(right)

        var count = 0
        var i = 0
        var j = 0
        val lSize = left.size
        val rSize = right.size
        mergeSort(left)
        mergeSort(right)
        while(i < lSize && j < rSize){
            if(left[i] > 2L*right[j]){
                count += lSize-i
                j++
            } else {
                i++
            }
        }

        return count+leftCount+rightCount;
    }

    /**
     * O(n log n)
     */
    fun mergeSort(A: IntArray){
        val n = A.size

        if(n < 2)
            return

        val mid = n/2
        val left = IntArray(mid)
        val right = IntArray(n - mid)
        for(i in 0 until mid)
            left[i] = A[i]
        for(j in mid until n)
            right[j - mid] = A[j]

        mergeSort(left)
        mergeSort(right)
        merge(A,left,right)
    }
    fun merge(A: IntArray,L: IntArray, R: IntArray){
        val lSize = L.size
        val rSize = R.size
        var i = 0
        var j = 0
        var k = 0

        while(i < lSize && j < rSize){
            if(L[i] <= R[j]){
                A[k] = L[i]
                i++
            } else {
                A[k] = R[j]
                j++
            }
            k++
        }

        while(i < lSize){
            A[k] = L[i]
            i++
            k++
        }

        while(j < rSize){
            A[k] = R[j]
            j++
            k++
        }
    }
}
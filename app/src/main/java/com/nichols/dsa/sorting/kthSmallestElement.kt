package com.nichols.dsa.sorting

class kthSmallestElement {
    fun solveMerging(A: IntArray, B: IntArray): IntArray {
        val n = A.size
        val m = B.size
        val c = IntArray(n+m)

        var i = 0
        var j = 0
        var k = 0
        //While  not out of bounds
        while(i<n && j<m){
            if(A[i] <= B[j]){
                c[k] = A[i]
                i++
                k++
            } else {
                c[k] = B[j]
                j++
                k++
            }
        }
        //while still some left in A
        while(i < n){
            c[k] = A[i]
            i++
            k++
        }
        //while still some left in B
        while(j < m){
            c[k] = B[j]
            j++
            k++
        }
        return c
    }
    fun solveInversionCount(A: IntArray): Int {
        return 0
    }
    fun solve(A: IntArray, B: IntArray): IntArray {
        //BRUTE FORCE
        val x = (A+B)
        x.sort()
        return x
    }

    fun merge(A: IntArray, l:Int, y:Int, r: Int){
        var i = l
        var j = y
        var k =0
        val c = IntArray(r-l+1)
        //create sorted c array
        while(i < y && j <= r){
            if(A[i] <= A[j]){
                c[k] = A[i]
                i++
            } else {
                c[k] = A[j]
                j++
            }
            k++
        }

        while(j <= y){
            c[k] = A[i]
            i++
            k++
        }

        while(j <= r){
            c[k] = A[j]
            j++
            k++
        }

        k = 0
        for(i in l..r){
            A[i] = c[k]
            k++
        }

    }
    fun kthsmallest(A: IntArray, B: Int): Int {
        for(i in A.indices){
            var min = A[i]
            var idx = i
            for(j in i until A.size){
                //swap
                if(A[j] < min){
                   min = A[j]
                    idx = j
                }
            }
            //swap
            val tmp = A[idx]
            A[idx] = A[i]
            A[i] = tmp
        }
        return A[B]
    }
}
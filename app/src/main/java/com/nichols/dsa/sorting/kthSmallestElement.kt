    package com.nichols.dsa.sorting

    class kthSmallestElement {
        fun solveInversionCdxount(A: IntArray): Int {
            //brute force
    //        var invCount = 0
    //        for(i in A.indices)
    //            for(j in (i+1) until A.size)
    //                if(A[i]>A[j])
    //                    invCount++
    //        return invCount
            return mergeSortAndCount(A,0,A.size-1)
        }

        fun mergeSortAndCount(A:IntArray, l:Int, r:Int) : Int{
             var count = 0
             if(l<r){
                 var m = (l+r)/2
                 //left subarray
                 count += mergeSortAndCount(A,l,m)
                 //right sub array
                 count += mergeSortAndCount(A,m+1,r)
                 //merge count
                 count += mergeAndCount(A,l,m,r)
             }
            return count
        }

        fun mergeAndCount(A:IntArray, l:Int, m:Int,r:Int): Int {
            val left = A.copyOfRange(l,m+1)
            val right = A.copyOfRange(m+1,r+1)

            var i =0
            var j = 0
            var k=l
            var swaps=0

            //while in range
            while(i < left.size && j < right.size){
                if(left[i] <=right[j]){
                    A[k++] = left[i++]
                } else {
                    A[k++] = right[j++]
                    swaps += (m+1) - (l+i)
                }
            }
            //get all from left
            while(i < left.size){
                A[k++] = left[i++]
            }
            //get all from right
            while(j < right.size){
                A[k++] = right[j++]
            }
            return swaps
        }
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
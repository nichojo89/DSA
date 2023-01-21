package com.nichols.dsa.twopointer

fun solve(A: IntArray, B: Int): IntArray {
    val n = A.size
    var left = 0
    var right = 0
    var sum = A[right]
    while(right<n&&left<=right){
        if(sum==B){
            return A.copyOfRange(left,right+1)
        }
        else if(sum < B){
            right++
            if(right<n)
                sum+=A[right]
        } else {
            sum -= A[left]
            left++
            if(left>right&&left<n){
                right++
                sum+= A[right]
            }
        }
    }
    return intArrayOf(-1)
}

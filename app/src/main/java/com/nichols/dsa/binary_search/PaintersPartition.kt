package com.nichols.dsa.binary_search

fun paint(A: Int, B: Int, C: IntArray): Int {
    var sum = 0
    val k = A
    for(i in C.indices)
        sum += C[i]
    var l = 0
    var r = sum
    val n = C.size
    var ans = Integer.MAX_VALUE
    while(l <=r){
        val mid = l + (r-l)/2
        if(isValid(C,n,k,mid)){
            ans = mid
            r = mid-1
        } else
            l = mid+1
    }

    return ans
}

fun isValid(arr: IntArray, n: Int, k:Int, curr_min: Int): Boolean {
    var painters = 1
    var curr_sum = 0
    for(i in 0..n){
        if(arr[i]>curr_min)
            return false
        if(curr_sum + arr[i] > curr_min){
            painters++
            curr_sum = arr[i]
            if(painters > k)
                return  false
        } else
            curr_sum += arr[i]
    }
    return true
}

class PaintersPartition {

//    bool isValid(int arr[], int n, int k, long long cur_min)
//    {
//        long long painters = 1;
//        long long cur_sum = 0;
//        for(long long i = 0; i < n; i++)
//        {
//            if(arr[i] > cur_min)

//            {
//                return false;
//            }
//            if(cur_sum + arr[i] > cur_min)
//            {
//                painters++;
//                cur_sum = arr[i];
//                if(painters > k)
//                {
//                    return false;
//                }
//            }
//            else
//            {
//                cur_sum += arr[i];
//            }
//        }
//        return true;
//    }

}